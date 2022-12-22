# Ex-Interface

Problema exemplo:

Uma locadora brasileira de carros cobra um valor por hora para locações de até
12 horas. Porém, se a duração da locação ultrapassar 12 horas, a locação será
cobrada com base em um valor diário. Além do valor da locação, é acrescido no
preço o valor do imposto conforme regras do país que, no caso do Brasil, é 20%
para valores até 100.00, ou 15% para valores acima de 100.00. Fazer um
programa que lê os dados da locação (modelo do carro, instante inicial e final da
locação), bem como o valor por hora e o valor diário de locação. O programa
deve então gerar a nota de pagamento (contendo valor da locação, valor do
imposto e valor total do pagamento) e informar os dados na tela.

Explicação: No primeiro commit foi resolvido esse problema usando dependencias nos contrutores ocasionando problemas
caso viesse a usar outro sistema de tributação, no segundo commit foi criado a interface que retinha o contrato para implementação
dos metodos, e atravez dessa interface retirou-se a dependencia da classe especifica no parametro da classe RentalServices, que agora
passou a receber um upcasting de um objeto que implementou a interface TaxServices

