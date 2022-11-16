## INSTRUÇÕES
Atividade avaliativa em grupo da matéria de Linguagem de Programação II que utiliza de recursos de estruturas de pilha na linguagem Java.
#### VAGÕES FERROVIÁRIOS
Neste projeto, considere 2 (duas) vias férreas, cada uma delas conectada a um terminal no qual se encontra uma composição
constituída por 1 (uma) locomotiva e 13 (treze) vagões de transporte de cargas. Os dois terminais se encontram em regiões com
vocações econômicas distintas; uma delas é voltada para a extração de minérios e outra para a produção de grãos, sendo
identificadas, respectivamente, por R1 e R2 e dependentes do sistema ferroviário em questão para a escoamento dos commodities
produzidos. Por limitações logísticas, as locomotivas são autorizadas a transitar apenas na própria via férrea na qual se encontram
atualmente, sendo possível, no entanto, que vagões sejam transferidos de uma composição para outra em ponto de interconexão
entre as duas vias férreas da forma como indicado na figura abaixo (ignore qualquer escala para identificação das dimensões reais
dos elementos ali representados).

![figura ilustrativa](/assets/Figura01.PNG)

Partindo da premissa de que é necessário identificar, a cada momento, quais vagões se encontram em cada composição admitindo-
se, inclusive, transferência de vagões e operações de embarque e desembarque de grãos e minérios nas estações, o projeto consiste

no desenvolvimento de aplicação responsável pela gestão de tais informações. O uso de coleções genéricas concretas para a
manipulação de pilhas é obrigatório. A aplicação desenvolvida deve dispor das seguintes funcionalidades e/ou restrições:
* Identificação de cada vagão por uma letra do alfabeto, não se admitindo, pois, dois ou mais vagões associados à mesma letra;
* Alteração de situação momentânea de cada composição admitindo-se três possibilidades acompanhadas das respectivas
operações passíveis de serem realizadas com seus vagões, a saber:

    | SITUAÇÃO                                   | OPERAÇÕES                                                   |
    |--------------------------------------------|-------------------------------------------------------------|
    | Em posição de carga/descarga (em terminal) | Embarque ou desembarque de produtos                         |
    | Em movimento                               | Nenhuma                                                     |
    | Em ponto de interconexão de vias férreas   | Transferência de vagões de composição para outra composição |
    
* Registro de operação de embarque de produto em vagão, quando este se encontrar em algum dos terminais conectados direta ou
indiretamente pelas vias férreas e exigindo-se, para tal, entrada dos seguintes dados: a) identificador de vagão; b) tipo de
minério (cobre, ferro, magnesita ou níquel) ou grão (amendoim, feijão, milho, soja ou trigo); e c) quantidade em quilogramas;
* Registro de operação de desembarque de produto carregado em vagão, quando este se encontrar em algum dos terminais
conectados direta ou indiretamente pelas vias férreas e exigindo-se, para tal, entrada de identificador daquele vagão;
* Registro de transferência de vagão de composição para outra composição considerando que ele se encontra na extremidade de
sua composição atual e exigindo-se igualmente entrada do identificador daquele vagão;
* Impedimento de operações de embarque e desembarque de produtos em vagão, quando este se encontrar em composição em
movimento ou em ponto de interconexão de vías férreas;
* Impedimento de operações de embarque de grãos em vagões de composição da via férrea conectada por terminal localizado na
região identificada por R1, asim como de operações de embarque de minérios em vagões de composição da via férrea
conectada por terminal localizado na região identificada por R2;
* Impedimento de operações de desembarque de minério em vagões de composição da via férrea conectada por terminal
localizado na região identificada por R1, asim como de operações de desembarque de grãos em vagões de composição da via
férrea conectada por terminal localizado na região identificada por R2;
* Impedimento de operação de transferência de vagão quando este se encontram em composição em posição de carga/descarga ou
em movimento;
* Consulta, a qualquer momento, da quantidade de desembarques, por tipo de commodities, nos terminais das regiões
identificadas por R1 e R2;
* Listagem dos vagões atuais de cada uma das 2 (duas) composições.
