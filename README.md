# Laboratorio-3

**integrantes**
- Karol Estefany Estupiñan Viancha
- Julian David Castiblanco Real
- Juan Carlos Leal Cruz

**Nombre de la rama**
feature/lab3_Estupiñan_Castiblanco_Leal_2025-2

___

## Resolución Preguntas

### A. Diferencia entre prueba unitaria y prueba de integración E2E
- **Prueba unitaria:** valida el correcto funcionamiento de un componente pequeño y aislado del software (por ejemplo, un método o clase) sin depender de otros módulos.
- **Prueba de integración E2E (End to End):** evalúa cómo interactúan múltiples componentes del sistema de principio a fin, incluyendo base de datos, servicios externos e interfaces de usuario.


### B. Propósito de la Sprint Retrospective en Scrum
La Sprint Retrospective busca que el equipo reflexione sobre cómo trabajó durante el sprint, identifique aciertos, errores y oportunidades de mejora.  
Es crucial porque fomenta la mejora continua, la colaboración y permite ajustar procesos antes del siguiente sprint.


### C. Diferencia entre Épica, Feature e Historia de Usuario
- **Épica:** Gran bloque de trabajo que abarca un objetivo amplio.  
  Ejemplo: "Mejorar la experiencia de visualización de los usuarios en la plataforma de streaming."

- **Feature:** Funcionalidad más específica que aporta valor.  
  Ejemplo: "Implementar la opción de descargas offline de películas y series."

- **Historia de Usuario:** Descripción concreta desde la perspectiva del usuario.  
  Ejemplo: "Como usuario quiero poder descargar un capítulo de una serie para verlo sin conexión a internet."


### D. Cobertura de Código (Code Coverage)
La cobertura de código mide qué porcentaje del código fuente se ejecuta durante las pruebas.  
Una cobertura del 100% no garantiza ausencia de errores porque:
- Puede haber pruebas que solo ejecuten el código pero no validen resultados.
- No cubre errores lógicos, de diseño, ni escenarios no considerados.

### E. Diagrama de Casos de Uso
Es una representación visual de cómo los actores (usuarios u otros sistemas)** interactúan con el sistema para lograr un objetivo.

**Elementos principales:**
- Actores
- Casos de uso (funcionalidades)
- Relaciones (asociación, inclusión, extensión)
- Sistema (el límite que encierra los casos de uso)

Sirve en la fase de análisis de requerimientos para entender y comunicar las necesidades funcionales del sistema** con stakeholders.

### F. Diferencia entre JUnit, Jacoco y SonarQube
- **JUnit:** Framework para escribir y ejecutar pruebas unitarias en Java.
- **Jacoco:** Herramienta para medir la cobertura de pruebas en el código.
- **SonarQube:** Analiza la calidad del software (código duplicado, bugs, vulnerabilidades, cobertura, etc.) y presenta métricas de manera centralizada.


### G. Ventajas del Planning Poker
- Permite que todo el equipo participe en la estimación.
- Reduce el sesgo de autoridad o de grupo, ya que todos votan al mismo tiempo.
- Fomenta la transparencia, la discusión y el compromiso colectivo.
- Convierte la estimación en un proceso colaborativo y más preciso.


### H. Valores de Scrum
Los cinco valores son:
1. Compromiso
2. Coraje
3. Enfoque
4. Apertura
5. Respeto

El más difícil de aplicar depende del equipo. Personalmente, el coraje suele ser el más complejo, porque implica hablar de problemas abiertamente, cuestionar decisiones y asumir riesgos para mejorar.

___

# Parte 2

Caso Bankify
___
## Reto 1 - Identificando los requerimientos

### Reglas de Negocio
1. Cada número de cuenta debe tener una longitud de 10 dígitos.
2. El número de cuenta solo puede contener números; no se permiten letras ni caracteres especiales.
3. Una cuenta solo es válida si los 2 primeros dígitos corresponden a un banco registrado.
4. Se deben poder realizar operaciones financieras con las cuentas válidas.

### Funcionalidades Principales

1. **Gestión de cuentas de usuarios**
  - Crear cuentas
  - Consultar información de cuentas
  - Validar cuentas

2. **Operaciones bancarias básicas**
  - Depositar dinero
  - Consultar saldo
  - Ver historial de transacciones

3. **Validaciones y seguridad**
  - Verificar la estructura del número de cuenta
  - Confirmar que el banco emisor está registrado
  - Asegurar consistencia en las operaciones

### Actores Principales

1. Bancos registrados
2. Clientes de Bankify

### Precondiciones

1. Contar con una lista de bancos registrados.
2. Para realizar un depósito o consultar saldo, la cuenta debe existir previamente.
3. Validar que el número de cuenta sea único (no duplicado).
4. La cuenta debe contener únicamente dígitos numéricos.
5. El saldo de la cuenta debe ser mayor a 0.
___

## Reto 2 - Diseñando

**Evidencia:**
- **Diagrama de contexto:**

<img width="1378" height="817" alt="image" src="https://github.com/user-attachments/assets/e7e05e1f-d174-4839-8425-5c66473e9bd0" />

- **Diagrama de Casos de uso:**

<img width="922" height="828" alt="image" src="https://github.com/user-attachments/assets/9fe27ac2-bd90-48b5-8b51-9affcb4735b4" />

- **Historias de Usuario:**

<img width="1389" height="484" alt="image" src="https://github.com/user-attachments/assets/809d53fd-7702-4c36-8471-b43f933b2091" />

- **Tabla de Excel:**

<img width="771" height="320" alt="image" src="https://github.com/user-attachments/assets/aae45c66-684a-4fe4-a2e2-d4d94fac3fd8" />

- **Diagrama de Clases:**

<img width="2594" height="1157" alt="image" src="https://github.com/user-attachments/assets/c63769af-8a6c-4123-be57-50dbf5eb7f71" />

___

## Reto 3

**Evidencia de funcionamiento**

Adjuntamos la evidencia de que el código del reto 3 está funcionando de forma correcta y estimada.

![Captura](/IdeaProjects/Laboratorio-3-DOSW-1/docs/images/fun1.png)

![Captura](/IdeaProjects/Laboratorio-3-DOSW-1/docs/images/fun2.png)

___
## Reto 4

Se crean en total cinco clases que garantizan el funcionamiento del sistema de Bankify, siendo las más importantes:

- **BankifyValidacion:** Se encarga de hacer la validación de cuentas junto con la consulta de cuentas y bancos.
- **BankifyGestion:** Toma las validaciones que se hacen en la clase anterior y las usa para crear cuentas, consultarlas, consultar los saldos y realizar depósitos

Todo lo anterior, se hace gracias a las otras clases de modelo que se crearon como lo son Cuenta, Cliente y Deposito. Por otro lado tenemos dos clases de pruebas para validar el funcionamiento y a continuación dejamos la evidencia del funcionamiento:

![Captura](/IdeaProjects/Laboratorio-3-DOSW-1/docs/images/validacion.png)
![Captura](/IdeaProjects/Laboratorio-3-DOSW-1/docs/images/gestion.png)

___
## Reto 5

Añadimos jacoco a pom.xml, junto con las condicion de que las pruebas deben estar al 85% min

<img width="876" height="1187" alt="image" src="https://github.com/user-attachments/assets/976ba7a1-e9c1-4991-808f-9c2e07cccb16" />

Al correr maven con el comando **mvn clean verify** tendremos el siguiente error por falta de pruebas

<img width="1532" height="426" alt="image" src="https://github.com/user-attachments/assets/3c05a81f-3a14-417b-8399-265dfee9943c" />

Añadimos la Prueba del reto 3 y confirmamos de que las pruebas ya abarcan mas del 85% de la extensión

<img width="732" height="1143" alt="image" src="https://github.com/user-attachments/assets/f8e0817f-016e-4f9a-bed6-62e5fc68b8c2" />
<img width="1370" height="698" alt="image" src="https://github.com/user-attachments/assets/27ab7c4e-bdf8-446c-9194-c2709d253860" />

## Reto 6
Observamos que las pruebas en realidad no cubren el 85% del codgo por lo que nos toca modificar el pom.xml para poder correr el reporte

<img width="883" height="244" alt="Captura de pantalla de 2025-09-04 23-41-42" src="https://github.com/user-attachments/assets/8219db6c-a697-4be7-bcde-7791a4fc3cf4" />

**¿Por qué considera que es importante realizar pruebas a un software diseñado?**

- Reflexión Karol: Porque con las pruebas uno se asegura de que el programa realmente funcione como debe, que no tenga errores raros, y también evita que en producción se caiga o falle.
- Reflexión Julian: Las pruebas y la cobertura permiten verificar que cada función cumpla su objetivo y que los cambios no afecten lo ya codificado, asegurando que se eviten fallas en el proyecto. 
- Reflexión Juan Carlos: Es importante realizar pruebas al software para: Detectar errores antes de que lleguen a los usuarios finales, garantizar que funcione correctamente según los requisitos establecidos, reducir costos de corrección (es más barato arreglar bugs antes del lanzamiento), y mantener la confianza del usuario evitando fallos que puedan afectar su experiencia o causar pérdidas.Las pruebas aseguran calidad, confiabilidad y reducen riesgos operativos.

  

