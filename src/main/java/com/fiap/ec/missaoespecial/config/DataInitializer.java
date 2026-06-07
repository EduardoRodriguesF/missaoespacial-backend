package com.fiap.ec.missaoespecial.config;

import com.fiap.ec.missaoespecial.enums.SensorStatus;
import com.fiap.ec.missaoespecial.model.*;
import com.fiap.ec.missaoespecial.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final MissaoRepository missaoRepository;
    private final ModuloRepository moduloRepository;
    private final SensorRepository sensorRepository;
    private final AlertaRepository alertaRepository;
    private final AnotacaoMissaoRepository anotacaoRepository;

    public DataInitializer(MissaoRepository missaoRepository,
                           ModuloRepository moduloRepository,
                           SensorRepository sensorRepository,
                           AlertaRepository alertaRepository,
                           AnotacaoMissaoRepository anotacaoRepository) {
        this.missaoRepository = missaoRepository;
        this.moduloRepository = moduloRepository;
        this.sensorRepository = sensorRepository;
        this.alertaRepository = alertaRepository;
        this.anotacaoRepository = anotacaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Criar M�dulos
        Modulo moduloComando = new Modulo(null, "Módulo de Comando", "Cabine principal da tripulação");
        Modulo moduloServico = new Modulo(null, "Módulo de Serviço", "Sistemas de propulsão e suporte de vida");
        moduloRepository.saveAll(Arrays.asList(moduloComando, moduloServico));

        // 2. Criar Sensores
        Sensor sensorPressao = new Sensor(null, "Sensor de Pressão", "Monitora a pressão interna", SensorStatus.OK, moduloComando);
        Sensor sensorTemp = new Sensor(null, "Sensor de Temperatura", "Monitora a temperatura do motor", SensorStatus.EM_ALERTA, moduloServico);
        Sensor sensorO2 = new Sensor(null, "Sensor de O2", "Níveis de Oxigênio", SensorStatus.OK, moduloComando);
        sensorRepository.saveAll(Arrays.asList(sensorPressao, sensorTemp, sensorO2));

        // 3. Criar Alertas
        Alerta alertaTemp = new Alerta(null, "Superaquecimento", "Temperatura acima do limite operacional no motor principal", sensorTemp, new Date());
        alertaRepository.save(alertaTemp);

        // 4. Criar Miss�o
        Missao missaoArtemis = new Missao(null, "Missão Artemis I", "Retorno à Lua", "EM_ANDAMENTO",
                Arrays.asList(moduloComando, moduloServico), 
                Arrays.asList(sensorPressao, sensorTemp, sensorO2),
                Collections.emptyList()
        );
        missaoRepository.save(missaoArtemis);

        // 5. Criar Anota��es
        AnotacaoMissao anotacao1 = new AnotacaoMissao(null, "Lançamento", "Lançamento executado com sucesso às 08:00", missaoArtemis, new Date());
        AnotacaoMissao anotacao2 = new AnotacaoMissao(null, "Anomalia", "Anomalia térmica detectada no Módulo de Serviço", missaoArtemis, new Date());
        anotacaoRepository.saveAll(Arrays.asList(anotacao1, anotacao2));

        System.out.println("Dados de exemplo inicializados com sucesso!");
    }
}
