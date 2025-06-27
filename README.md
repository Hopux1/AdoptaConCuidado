# 🐾 AdoptaConCuidado

**Proyecto Evaluación Unidad 3 – Patrones de Diseño** 
**Nombre:** André Piffaut
**Asignatura:** Patrones de Diseño  
**Profesor:** Giovanni Cáceres    
**Fecha de entrega:** 25 de junio  

---

## 🎯 Descripción del sistema

`AdoptaConCuidado` es una aplicación Java con interfaz visual que simula un sistema de adopción de mascotas con tenencia responsable.  
Permite a los usuarios:

- Ver mascotas disponibles para adopción, cada una con nombre y descripción.
- Ingresar su nombre y adoptar una mascota del tipo deseado.
- Generar un historial de adopciones.
- Visualizar todo en una interfaz gráfica con fondo ilustrado.

La aplicación fue diseñada para demostrar el uso correcto de **4 patrones GoF** integrados en una solución funcional y clara.

---

## 🧩 Patrones de Diseño Aplicados

### 1. **Creacional – Singleton**  
**Clase:** `AdopcionManager`  
Este patrón asegura que exista **una única instancia global** que gestiona las adopciones y mascotas disponibles.  
Se usa para centralizar el historial y el catálogo de mascotas, garantizando consistencia en todo el sistema.

### 2. **Estructural – Adapter**  
**Clase:** `MascotaExternaAdapter`  
Permite integrar futuras fuentes de datos externas (por ejemplo, mascotas de otra API o sistema externo) al formato interno `Mascota`.  
Esto da flexibilidad para ampliar sin romper la estructura actual.

### 3. **De Comportamiento – Observer (estructurado)**  
**Interfaz:** `Observador`  
Aunque actualmente no se instancian observadores concretos, la aplicación ya contempla una arquitectura extensible para que componentes sean notificados automáticamente (por ejemplo, para alertas futuras o sincronización con bases de datos).

### 4. **Libre elección – Factory Method**  
**Clase:** `MascotaFactory`  
Encapsula la lógica de creación de objetos `Mascota` según el tipo (Perro, Gato, etc.).  
Facilita la extensión del sistema a nuevos tipos sin modificar el código principal.

---

## 🖥️ Instrucciones de compilación y ejecución

### ⚙️ Compilación

1. Abre CMD desde la raíz del proyecto:
```bash
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
```

2. Ejecuta el programa:
```bash
java -cp bin main.Main
```

✅ Asegúrate de tener la imagen `img/fondo.png` en el lugar correcto para que se vea el fondo ilustrado.

---

## 🖼️ Interfaz Visual

- **Menú principal** con botones: Ver Mascotas, Adoptar, Historial.
- **Entrada personalizada** con campos de texto para ingresar nombre y tipo de mascota.
- **Fondo temático ilustrado** con estilo amigable.
- **Texto centrado arriba** y con formato claro.

---

## ✅ Justificación técnica de patrones

🔒 Singleton – AdopcionManager

Usado para que exista una sola instancia que maneje todo el sistema de adopciones y mascotas disponibles.
Evita inconsistencias y permite un acceso centralizado desde cualquier parte del programa.

🏭 Factory Method – MascotaFactory

Permite crear mascotas según el tipo sin usar new directamente.
Facilita agregar nuevos tipos sin modificar la lógica principal, manteniendo el código extensible y ordenado.

🔌 Adapter – MascotaExternaAdapter

Adapta clases externas para que se comporten como Mascota.
Prepara el sistema para integrar datos de otras fuentes sin romper la estructura interna.

📣 Observer – Observador

Define una base para que el sistema pueda notificar cambios a otros componentes (como futuras alertas o registros).
Aún no se usa activamente, pero permite escalar el sistema fácilmente a futuro.

---

## 📚 Conclusión

Este sistema fue desarrollado con foco en aplicar patrones GoF de forma coherente en un contexto realista y visualmente agradable.  
Está preparado para futuras mejoras como persistencia, notificaciones o conexión con servicios externos.

---

> **“Adoptar una mascota es un acto de amor... diseñar con patrones también 🐶”**
