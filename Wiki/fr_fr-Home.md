# ✈️ Vanilla Outsider: Creative Fly Speed Wiki Officiel

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Clause de non-responsabilité relative au code source** : La documentation de ce Wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure des commits récents non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.

---

## 🎯 Bienvenue sur la Documentation Officielle

**Creative Fly Speed** est un mod de cinématique de vol haute performance et ultra-léger de la **Vanilla Outsider Collection**, conçu par **Dasik (Rifaditya)**. Il offre aux constructeurs, créateurs de cartes, administrateurs et réalisateurs un contrôle fluide et natif de la vitesse de vol en modes Créatif et Spectateur via des règles de jeu (GameRules) synchronisées par le serveur.

Conçu selon le principe de **Liberté Totale du Joueur (Player Agency & Anti-Nanny Invariant)**, aucun plafond artificiel n'est imposé : les joueurs peuvent pousser la vitesse jusqu'à $100\times$ pour des déplacements instantanés ou la ralentir à $0.1\times$ pour un placement de blocs au millimètre près.

---

## 🧭 Portail de Sélection des Versions

Choisissez votre version cible de Minecraft pour accéder à l'arborescence dédiée :

| Version Cible | Ancrage de Version | Chaîne de Compilation | Statut | Accès Direct |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 Actuel | [[👉 Entrer sur le Wiki MC 26.3|26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 Parité | [[👉 Entrer sur le Wiki MC 26.2|26.2-Home]] |

> [!NOTE]
> En vertu de la politique **1 Jar 1 Version Policy**, chaque branche de version est construite comme un artefact souverain et autonome.

---

## 🌟 Vue d'ensemble des Sous-systèmes

- **[[Cinématique de vol|26.3-Flight-Speed-Kinematics]]** :
  - Calcul de vitesse en permille : $S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ blocs/tick.
  - Vitesse de sprint cumulée : accélération de $1.4\times$ en vol rapide.
  - Garde-fou anti-dérive ($10^{-6}\text{ F}$) pour éliminer les paquets réseau inutiles.
  - Isolation totale : aucun impact sur les modes Survie et Aventure.
- **[[Configuration & GameRules|26.3-Configuration-and-GameRules]]** :
  - Catégorie dynamique `vo_creative_fly_speed:fly_speed` enregistrée via DasikLibrary.
  - `vo_creative_fly_speed` : Vitesse de vol en mode Créatif (défaut : `1000` = $1.0\times$).
  - `vo_spectator_fly_speed` : Vitesse de vol en mode Spectateur (défaut : `1000` = $1.0\times$).
  - Plage de `1` à `100000`, sauvegardée directement dans `level.dat`.
- **[[Architecture & Mixins|26.3-Architecture-and-Mixins]]** :
  - Injection ciblée dans `ServerPlayer.tick()` à `@At("HEAD")`.
  - Purity Law : zéro logique métier dans le Mixin, délégation à `FlySpeedLogic`.
  - Complexité algorithmique $O(1)$ sans allocation mémoire sur le tas.

---

## 📚 Guides Développeurs & Dépannage

- [[Matrice de Compatibilité|Version-Compatibility]] : Spécifications Loom, Fabric Loader et Java 25.
- [[Dépannage & Foire Aux Questions (FAQ)|Troubleshooting-and-FAQ]] : Résolution des problèmes de synchronisation et paquets.
- [[Guide de Compilation pour Développeurs|Developer-Setup-and-Building]] : Compilation autonome avec Gradle 9.3+.

---

## 📜 Crédits & Licence

- **Auteur & Concepteur** : **Dasik (Rifaditya)**
- **Licence** : **GNU General Public License v3.0 (GPLv3)**
- **Code Source** : [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
