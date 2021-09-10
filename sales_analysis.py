Principios SOLID
Single responsability: 	que las clases sólo hagan 1 cosa

Open Closed: 			El principio Open/Closed dice que una clase/método debe estar abierto a extensiones pero cerrado a modificaciones.

Liskov Substitution: 	Este principio trata sobre que los objetos de un desarrollo deberían ser reemplazables por instancias de sus subtipos sin alterar el correcto funcionamiento del desarrollo. 
						Dicho de otro modo: cualquier subclase debería poder ser sustituible por la clase padre.

Interface Segregation:	Este principio trata sobre algo parecido a SRP. Es mejor definir una serie de métodos abstractos a través de una serie de interfaces para que implementen nuestras clases.
						Cada interface tendrá una única responsabilidad. Es preferible tener muchas interfaces que contengan pocos métodos que tener un interface con muchos métodos.

Dependency Inversion:	El objetivo de este principio es conseguir desacoplar las clases de nuestro desarrollo. Que una clase pueda funcionar por sí sola sin depender de otra. 
						Es difícil, pero en todo diseño de software al final suele existir un acoplamiento, pero hay que evitarlo en la medida de lo posible. Un sistema altamente acoplado es muy difícil de mantener.