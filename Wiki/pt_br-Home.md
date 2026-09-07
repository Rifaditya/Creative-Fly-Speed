# ✈️ Vanilla Outsider: Creative Fly Speed Wiki Oficial

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Aviso Legal do Código-Fonte do Repositório**: A documentação desta Wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir commits recentes ainda não lançados ou recursos em desenvolvimento antes das versões públicas no CurseForge e Modrinth.

---

## 🎯 Bem-vindo à Documentação Oficial

**Creative Fly Speed** é um mod de cinemática de voo de alta performance e ultra-leve da **Vanilla Outsider Collection**, desenvolvido por **Dasik (Rifaditya)**. Ele fornece a construtores, criadores de mapas, administradores de servidores e cineastas um controle suave e nativo da velocidade de voo nos modos Criativo e Espectador por meio de GameRules sincronizadas pelo servidor.

Projetado sob o princípio da **Autonomia do Jogador (Player Agency & Anti-Nanny Invariant)**, nenhum teto artificial é imposto: os jogadores podem acelerar o voo até $100\times$ a velocidade base para travessias rápidas ou reduzi-la para $0.1\times$ para detalhes minuciosos.

---

## 🧭 Portal Seletor de Versões

Selecione sua versão alvo do Minecraft para acessar a árvore de documentação dedicada:

| Versão Alvo | Lançamento | Ferramentas | Status | Portal Direto |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 Atual Principal | [[👉 Entrar na Wiki do MC 26.3|pt_br-26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 Paridade | [[👉 Entrar na Wiki do MC 26.2|pt_br-26.2-Home]] |

> [!NOTE]
> Sob a política **1 Jar 1 Version Policy**, cada versão é construída como um artefato soberano e autônomo com mapeamentos dedicados.

---

## 🌟 Visão Geral dos Subsistemas

- **[[Cinemática de Velocidade de Voo|pt_br-26.3-Flight-Speed-Kinematics]]**:
  - Cálculo de velocidade por permille: $S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ blocos/tick.
  - Multiplicador de sprint: aceleração adicional de $1.4\times$ durante o voo correndo.
  - Proteção de deriva em ponto flutuante ($10^{-6}\text{ F}$) para eliminar tráfego de rede desnecessário.
  - Totalmente seguro: modos Sobrevivência e Aventura são completamente intocados.
- **[[Configuração & GameRules|pt_br-26.3-Configuration-and-GameRules]]**:
  - Registro de categoria dinâmica `vo_creative_fly_speed:fly_speed` via DasikLibrary.
  - `vo_creative_fly_speed`: Multiplicador de voo Criativo (padrão `1000` = $1.0\times$).
  - `vo_spectator_fly_speed`: Multiplicador de voo Espectador (padrão `1000` = $1.0\times$).
  - Intervalo irrestrito de `1` a `100000`, persistido nativamente em `level.dat`.
- **[[Arquitetura & Mixins|pt_br-26.3-Architecture-and-Mixins]]**:
  - Injeção precisa em `ServerPlayer.tick()` no ponto `@At("HEAD")`.
  - Zero lógica de negócios no Mixin: delegação total ao utilitário `FlySpeedLogic`.
  - Eficiência $O(1)$ sem alocações de memória no heap.

---

## 📚 Documentação Geral & Solução de Problemas

- [[Matriz de Compatibilidade|pt_br-Version-Compatibility]]: Especificações de Loom, Fabric Loader e Java 25.
- [[Solução de Problemas & Perguntas Frequentes (FAQ)|pt_br-Troubleshooting-and-FAQ]]: Resolução de travamentos, pacotes e salvamento.
- [[Guia de Compilação para Desenvolvedores|pt_br-Developer-Setup-and-Building]]: Compilação via Gradle 9.3+.

---

## 📜 Créditos & Licença

- **Autor & Desenvolvedor**: **Dasik (Rifaditya)**
- **Licença**: **GNU General Public License v3.0 (GPLv3)**
- **Código Fonte**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
