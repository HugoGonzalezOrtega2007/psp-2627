# Actividad 1 — "La Cocina Boloñesa": Simulación de una receta en Java

Fecha límite de entrega: Domingo 11/10/2026 a las 23:59

## Contexto

Vas a modelar en Java el proceso de preparación de una receta de **espaguetis a la boloñesa**, representando cada fase de la cocina como si fuera un proceso del sistema operativo: tareas que consumen recursos (ingredientes), se ejecutan en unidades de trabajo (sartenes, cazuelas, olla) y siguen una secuencia de pasos con una duración.

Esta primera entrega es **totalmente secuencial** (un solo hilo de ejecución, el `main`). En actividades posteriores retomarás este mismo código para introducir hilos, sincronización y ejecución concurrente de las distintas sartenes/cazuelas. Por eso es importante que el diseño de clases sea limpio y extensible desde ya.

## Objetivo

Implementar en Java un programa que simule, paso a paso y en orden, la elaboración completa de la receta, mostrando por consola el avance del proceso (qué hace el cocinero, en qué "recipiente/proceso" y con qué ingredientes) y el tiempo que tarda cada paso.

## Elementos a modelar

Como mínimo, el programa debe tener las siguientes clases/entidades:

1. **`Ingrediente`**
   - Nombre, cantidad, unidad (g, ml, unidades...).
2. **`Cocinero`**
   - Nombre.
   - Método(s) para ejecutar una `Paso` de la receta.
3. **`Recipiente`**: representa una sartén, cazuela u olla.
   - Nombre/tipo (ej. "Sartén grande", "Olla de agua").
   - Estado (vacío, en uso, terminado).
   - Lista de ingredientes que contiene en cada momento.
4. **`PasoReceta`** (o `Tarea`)
   - Descripción de la acción (ej. "Sofreír la cebolla").
   - Recipiente donde se ejecuta.
   - Ingredientes que interviene.
   - Duración simulada (en segundos, usando `Thread.sleep()` a modo de "tiempo de cocción").
5. **`Receta`**
   - Lista ordenada de `PasoReceta`.
   - Método para ejecutar la receta completa en orden.

## Pasos mínimos de la receta a simular

El programa debe reproducir, en este orden secuencial, algo equivalente a:

1. Poner agua a hervir en la olla (recurso: olla, ingrediente: agua + sal).
2. Cocer los espaguetis en la olla.
3. Sofreír la cebolla y el ajo en la sartén con aceite.
4. Añadir la carne picada y dorarla.
5. Añadir el tomate y dejar reducir la salsa.
6. Escurrir la pasta.
7. Mezclar la pasta con la salsa boloñesa.
8. Emplatar.

Podéis ajustar/enriquecer los pasos, pero deben quedar claramente representados como objetos, no como simples `System.out.println()` sueltos.

## Requisitos técnicos

- El programa debe ejecutarse desde un `main` y mostrar por consola, para cada paso:
  - Qué recipiente se usa.
  - Qué ingredientes intervienen.
  - Cuánto tiempo (simulado) tarda.
  - Cuándo empieza y cuándo termina (puedes usar `System.currentTimeMillis()` o `LocalTime.now()`).
- Cada paso debe tener una duración simulada distinta (usad `Thread.sleep(milisegundos)`), para que en la siguiente actividad se note claramente la diferencia entre ejecutar todo en secuencia vs. en paralelo.
- Al finalizar, el programa debe mostrar el **tiempo total** que ha tardado en completarse la receta.
- Uso correcto de **POO**: encapsulación, al menos una relación de composición/agregación clara (Receta tiene Pasos, Paso usa Recipiente e Ingredientes).
- Nada de hilos todavía: todo se ejecuta en el hilo principal, un paso detrás de otro.

## Entregable

- Código fuente Java correctamente organizado en paquetes/clases.
- Una captura o log de la ejecución mostrando la traza completa de la receta y el tiempo total.

## Criterios de evaluación orientativos

| Criterio | Peso |
|---|---|
| Modelado correcto de clases (Cocinero, Ingrediente, Recipiente, Paso, Receta) | 30% |
| Ejecución secuencial correcta y coherente de todos los pasos | 30% |
| Simulación de tiempos con `Thread.sleep` y cálculo del tiempo total | 20% |
| Calidad del código (nombres, encapsulación, organización en paquetes) | 20% |

## Pista de cara al futuro (no implementar aún)

Diseñad `PasoReceta` y `Recipiente` pensando en que, en la próxima actividad, cada `Recipiente` podría ejecutarse en su propio `Thread`, y que algunos pasos dependerán de que otro haya terminado (por ejemplo, no se puede mezclar la pasta con la salsa hasta que ambas estén listas). Si desde ya evitáis acoplar la lógica de "cuándo se ejecuta" dentro de la propia tarea, el salto a hilos será mucho más sencillo.