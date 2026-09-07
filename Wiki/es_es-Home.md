# ✈️ Vanilla Outsider: Creative Fly Speed Wiki Oficial

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Descargo de responsabilidad sobre el código fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las versiones públicas en CurseForge y Modrinth.

---

## 🎯 Bienvenido a la Documentación Oficial

**Creative Fly Speed** es un mod de cinemática de vuelo ligero y de alto rendimiento de la **Vanilla Outsider Collection**, desarrollado por **Dasik (Rifaditya)**. Proporciona a constructores, creadores de mapas, operadores de servidores y cineastas un control nativo y fluido de la velocidad de vuelo en los modos Creativo y Espectador mediante GameRules sincronizadas con el servidor.

Diseñado bajo la **Libertad de Agencia del Jugador (Player Agency & Anti-Nanny Invariant)**, no impone techos artificiales: los jugadores pueden aumentar la velocidad de vuelo hasta $100\times$ para atravesar mundos rápidamente o reducirla a $0.1\times$ para construcciones de precisión milimétrica.

---

## 🧭 Portal Selector de Versiones

Seleccione su versión de Minecraft para acceder al árbol de documentación dedicado:

| Versión Objetivo | Anclaje de Versión | Herramientas | Estado | Portal Directo |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 Versión Actual | [[👉 Entrar a la Wiki de MC 26.3|es_es-26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 Anclaje de Paridad | [[👉 Entrar a la Wiki de MC 26.2|es_es-26.2-Home]] |

> [!NOTE]
> Bajo la política **1 Jar 1 Version Policy**, cada rama de versión se construye como un artefacto soberano e independiente con sus asignaciones de dependencias.

---

## 🌟 Resumen de Subsistemas Principales

- **[[Cinemática de velocidad de vuelo|es_es-26.3-Flight-Speed-Kinematics]]**:
  - Cálculo de velocidad por permille: $S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ bloques/tick.
  - Multiplicador de sprint compuesto ($1.4\times$).
  - Filtro de deriva en coma flotante ($10^{-6}\text{ F}$) para evitar saturación de paquetes en red.
  - Operación segura: no interfiere con los modos Supervivencia ni Aventura.
- **[[Ajustes y GameRules|es_es-26.3-Configuration-and-GameRules]]**:
  - Registro dinámico bajo la categoría `vo_creative_fly_speed:fly_speed` mediante DasikLibrary.
  - `vo_creative_fly_speed`: Multiplicador en modo Creativo (por defecto `1000` = $1.0\times$).
  - `vo_spectator_fly_speed`: Multiplicador en modo Espectador (por defecto `1000` = $1.0\times$).
  - Rango completo de `1` a `100000`, persistido de forma nativa en `level.dat`.
- **[[Arquitectura y Mixins|es_es-26.3-Architecture-and-Mixins]]**:
  - Inyección limpia en `ServerPlayer.tick()` en `@At("HEAD")`.
  - Cero lógica de negocio en el Mixin: delegación total en `FlySpeedLogic`.
  - Rendimiento $O(1)$ sin asignación de memoria dinámica (heap).

---

## 📚 Documentación General y Solución de Problemas

- [[Matriz de compatibilidad de versiones|es_es-Version-Compatibility]]: Entornos de compilación Loom, Fabric Loader y Java 25.
- [[Solución de problemas y FAQ|es_es-Troubleshooting-and-FAQ]]: Guía de resolución de desincronización, paquetes y persistencia.
- [[Guía de compilación para desarrolladores|es_es-Developer-Setup-and-Building]]: Instrucciones de compilación con Gradle 9.3+.

---

## 📜 Créditos y Licencia

- **Autor y Mantenimiento**: **Dasik (Rifaditya)**
- **Licencia**: **GNU General Public License v3.0 (GPLv3)**
- **Código Fuente**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
