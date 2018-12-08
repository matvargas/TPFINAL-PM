
## INSTITUTO DE CIÊNCIAS EXATAS 
### Departamento de Ciência da Computação 
### Programação Modular -Trabalho Prático Final – 2018/2 


**Especificação** 
A direção da cooperativa Clinica SaraCura deseja desenvolver um sistema para administrar agendas de atendimento médico e de exames de imagem. O sistema deverá apresentar uma interface inicial para o operador selecionar entre agendamento de consulta, agendamento de exame de imagem, atualização do cadastro de agendas (médicas e de exames) ou encerramento do sistema. 

**Sobre médicos e consultas** 

![alt text](https://github.com/matvargas/TPFINAL-PM/blob/master/saracurahc/src/main/resources/static/images/gifs/scheduling.gif "Agendamento")

A clínica tem muitos médicos afiliados e o número de médicos altera de forma dinâmica com a inclusão e a exclusão de médicos. O sistema deverá gerenciar agendas individuais de cada médico. 

Cada médico tem sua própria agenda na cooperativa contendo seus dados pessoais, suas especialidades e a disponibilidade de horário. Um médico atende durante 6 horas contínuas entre 7h e 20h, três vezes por semana. O intervalo de cada consulta pode ser de 15, 20 ou 30 minutos conforme escolha do médico. 

Na interface inicial do sistema quando a escolha for agendamento de consulta, a próxima interface deverá apresentar uma lista de especialidades para escolha. Após a escolha da especialidade, deverá ser apresentada uma lista de médicos aptos a atender a consulta. Ao escolher o médico abre-se a sua agenda. 

Cada médico tem a sua agenda particular, porém a interface para operar a agenda é a mesma para todas. Nela o operador escolherá a data e a hora da consulta que atendam ao cliente. Ao agendar, será lançado o nome do cliente, o telefone e selecionada a forma de atendimento - Convenio ou Particular. No caso de convenio deve ser lançado o nome do convenio e o a matricula do cliente no convenio. Caso a consulta seja particular deverá ser marcada a opção entre cheque, cartão - crédito ou débito, ou pagamento em espécie. No caso de convenio antes de confirmar o agendamento é preciso solicitar a autorização e no caso de consulta particular será preciso validar o pagamento em cheque ou cartão. Após autorização, ou confirmação do pagamento, da consulta o agendamento poderá ser confirmado e a agenda do médico deverá ser fechada e o sistema deve retornar à tela inicial. Caso não seja autorizado, ou o pagamento recusado, o agendamento do atendimento deverá ser cancelado e o sistema deve retornar à tela inicial.

**Sobre os exames** 

As agendas para exames são gerenciadas por equipamento. Cada equipamento tem sua agenda e pode funcionar de 7h às 20h em intervalos de 20 minutos para cada procedimento. Entretanto as agendas devem ser organizadas por tipos de exame (Tomografia Computadorizada, Ressonância Magnética, Ultrasom, etc.), já que para cada tipo é necessário a presença de um médico especializado no tipo de exame. Isso significa - considerando-se dois equipamentos - que em determinado horário será possível marcar uma Ressonância Magnética no equipamento 1 e outra no equipamento 2. Pode acontecer que em determinados horários, apenas um aparelho esteja disponível já que o outro pode estar sem médico ou com defeito. Logo o operador do sistema deve ter acesso a informações sobre as agendas dos dois equipamentos para agendar exames do tipo Tomografia. 

A partir da tela inicial quando for escolhida a opção para agendamento de exame, uma lista dos tipos de exames disponíveis (Tomografia, Raio X, Ultrasom, etc.) deverá ser apresentada. Os tipos de exames servem para identificar o aparelho a ser usado e consequentemente sua agenda. 

Após escolher o tipo de exame, o operador escolhe a data para atender ao cliente e em sua tela deverão ser exibidas as agendas de todos os aparelhos disponíveis para o tipo de exame desejado, mostrando as horas disponíveis e os médicos responsáveis em cada intervalo. Ao lançar uma marcação o operador deverá registrar o nome do paciente e o seu telefone, a especificação do exame a ser realizado (por exemplo, Tomografia do joelho, direito, Tomografia da cabeça, Ultrasom (Scan) dos membros inferiores, etc.) e a forma de atendimento – convenio ou particular.Para pagamento de atendimento particular as opções são: cheque, cartão ou em espécie. As autorizações e pagamentos devem usar a mesma interface e os mesmos procedimentos já descritos para consulta. Após a confirmar a autorização ou o pagamento a agenda de exames deverá ser encerrada e o sistema retorna à tela inicial. 

**Validação do pagamento de atendimento particular.** 

Caso seja o atendimento (consulta ou exame) seja particular, serão admitidas três formas de pagamento: cheque, cartão - de débito ou de crédito, ou pagamento em espécie. Para estas formas, o sistema deverá validar o pagamento: no caso de cheque e de cartão de débito – simular uma consulta do banco e emitir um recibo. No caso de cartão de crédito simular uma consulta à administradora e o lançamento na fatura do cartão. No caso do pagamento em espécie basta a emissão de um recibo. Na simulação do pagamento via cheque ou cartão, deverá haver um sorteio para recusar um pagamento a cada dez consultas. Quando o pagamento for recusado, o agendamento do atendimento deverá ser cancelado. Validação do convenio Também no uso do convenio dever ocorrer uma simulação para obtenção da autorização. Neste caso, a cada doze tentativas deverá negada uma autorização. Para cada autorização negada deverá ser emitida uma mensagem informado que o convenio XXX não autorizou o procedimento YYY para o paciente ZZZ. E o agendamento do atendimento cancelado. 

**Sobre o projeto** 

O desenvolvimento do sistema deverá usar o paradigma modular e ser baseado em padrões de projeto. Cabe ao projetista escolher os mais adequados. Nos procedimentos de simulação de obtenção de autorização de convênio ou de validação de pagamentos (cheque ou cartão), deverão ser geradas exceções cujos tratamentos gerem as mensagens adequadas e levem ao cancelamento do atendimento. Devem ser usadas estruturas do tipo Collections (ou Map) para o armazenamento das agendas durante a execução do sistema. Fica a critério do projetista salvar as agendas em arquivos, ou banco de dados, quando do encerramento do sistema, para posterior recuperação durante a reinicialização do sistema Não há necessidade de criar cadastros de clientes e médicos. Mas, na tela inicial deverá haver uma opção para que o operador possa cadastrar novas agendas para novos médicos e para exames, possa editar agendas já existentes ou mesmo remove-las. Fica a critério do projetista desenvolver as interfaces e as funcionalidades para este cadastro de agendas.
