<p align="center">
<a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&amp;logo=discord&amp;logoColor=white" alt="Join Discord"></a>
<a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&amp;logo=fabric" alt="Requires Fabric API"></a>
<img src="https://img.shields.io/badge/Environment-Client_&amp;_Server-success?style=for-the-badge" alt="Client &amp; Server">
<img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&amp;logo=java" alt="Java 25">
<img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
<img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>
<h2>🦅 Creative Fly Speed</h2>
<blockquote><p><strong>"Unchain Creative Flight. Precision Maneuvering Meets Hypersonic World Navigation."</strong></p></blockquote>
<hr>
<h2>📖 Introduction</h2>
<p>Building mega-structures, designing massive redstone contraptions, and surveying vast terrain in Minecraft's Creative Mode is often crippled by vanilla's sluggish, one-speed flight mechanics. Double-tapping sprint grants a minor boost, but traversing thousands of blocks to inspect a biome or locate a structure still takes agonizing minutes. Conversely, when placing delicate stair blocks or wiring tight redstone circuits inside compact interiors, vanilla flight velocity is too fast and floaty, causing you to constantly overshoot your target.</p>
<p><strong>Creative Fly Speed</strong> gives you total, fluid mastery over flight dynamics. Designed with architectural precision under the <strong>Vanilla Outsider</strong> collection, it introduces dynamic mouse-scroll flight speed adjustment, sprint momentum scaling, calibrated vertical vs horizontal thrust, configurable inertia damping, and server-side packet authorization to eliminate annoying rubberbanding on multiplayer servers.</p>
<blockquote><p><strong>1 Jar 1 Version Policy:</strong> I build <strong>1 dedicated JAR for each Minecraft version</strong> (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation. <strong>Multiplayer Architecture:</strong> Works as a lightweight server mod with client synchronization. On dedicated servers running Creative Fly Speed, clients can fly at supersonic speeds without triggering vanilla "Flying is not enabled on this server" kicks or velocity rubberbanding!</p></blockquote>
<p>Part of the <strong>Vanilla Outsider Collection</strong> — modern mods designed to refine and elevate the vanilla Minecraft experience.</p>
<hr>
<h2>✨ Features</h2>
<h3>🎡 Dynamic Mouse-Scroll Speed Tuning</h3>
<ul>
  <li><strong>On-the-Fly Velocity Adjustment:</strong> Hold <code>Left Alt</code> (configurable) and scroll your mouse wheel up or down while flying to seamlessly scale your flight speed from a crawl ($0.1\times$) up to supersonic velocity ($20.0\times$).</li>
  <li><strong>Sub-Block Precision Mode:</strong> Dial speed down to $0.05\times$ for micrometer-level block placement, fine interior decoration, or cinematic camera tracking.</li>
  <li><strong>HUD Speed Bar Narration:</strong> Displays a clean, discreet action bar readout (e.g. <code>✈️ Fly Speed: 3.5x</code>) that fades away smoothly when adjustment ceases.</li>
</ul>
<h3>⚡ Calibrated Vertical &amp; Horizontal Vector Physics</h3>
<ul>
  <li><strong>Independent Vertical Thrust:</strong> Vanilla flight often feels unbalanced when ascending or descending. Creative Fly Speed allows independent calibration of vertical ascension speed (<code>creative_fly_speed:vertical_thrust_ratio</code>), making towering mega-build ascents effortless.</li>
  <li><strong>Sprint Momentum Surge:</strong> Double-tap sprint while flying to engage a configurable secondary momentum surge ($1.5\times$ to $5.0\times$ boost), perfect for quick bursts across build plots.</li>
  <li><strong>Inertia &amp; Drift Elimination:</strong> Eliminate vanilla's floaty slide upon releasing movement keys with customizable inertia damping for instant, crisp stopping.</li>
</ul>
<h3>🛡️ Server-Side Anti-Rubberband Enforcement</h3>
<ul>
  <li><strong>Smooth Dedicated Server Synchronization:</strong> On vanilla servers, flying faster than vanilla speed thresholds causes the server to constantly drag your position backward (rubberband) or kick you for illegal movement packets.</li>
  <li><strong>Integrated Server Guard:</strong> Creative Fly Speed handles player ability velocity packets authoritatively on the server, synchronizing custom velocity limits so all builders on your creative server enjoy silky smooth flight.</li>
</ul>
<hr>
<h2>📊 Feature Comparison Matrix</h2>
<table>
  <thead>
    <tr>
      <th>Flight Capability</th>
      <th>Vanilla Creative Flight</th>
      <th>Creative Fly Speed</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Speed Adjustment</strong></td>
      <td>Fixed single speed (minor sprint boost)</td>
      <td><strong>Dynamic $0.05\times$ to $20.0\times$ via mouse scroll</strong></td>
    </tr>
    <tr>
      <td><strong>Precision Building Mode</strong></td>
      <td>Impossible (requires crawling on blocks)</td>
      <td><strong>Dedicated sub-block micro-speed mode</strong></td>
    </tr>
    <tr>
      <td><strong>Vertical Ascension</strong></td>
      <td>Sluggish fixed $0.05$ blocks/tick</td>
      <td><strong>Calibrated vertical thrust ratio multiplier</strong></td>
    </tr>
    <tr>
      <td><strong>Inertia Stopping</strong></td>
      <td>Floaty momentum drift</td>
      <td><strong>Crisp, zero-drift instantaneous stopping</strong></td>
    </tr>
    <tr>
      <td><strong>Multiplayer Performance</strong></td>
      <td>Rubberbands and triggers flying kicks</td>
      <td><strong>Native server-authorized packet sync</strong></td>
    </tr>
    <tr>
      <td><strong>Spectator Mode Parity</strong></td>
      <td>Standard scroll-speed only</td>
      <td><strong>Unified controls across Creative &amp; Spectator</strong></td>
    </tr>
  </tbody>
</table>
<hr>
<h2>🎮 In-Game Commands &amp; Quick Controls</h2>
<p>Creative Fly Speed provides intuitive Brigadier commands for quick velocity calibration:</p>
<pre><code># Set your current flight speed multiplier to 3.5x
/flyspeed set 3.5

# Reset flight speed multiplier to default vanilla speed (1.0x)
/flyspeed reset

# Inspect your current horizontal and vertical flight metrics
/flyspeed status</code></pre>
<h3>Server-Side GameRules</h3>
<p>Server administrators can enforce global bounds and velocity ceilings using native namespaced GameRules:</p>
<table>
  <thead>
    <tr>
      <th>GameRule Key</th>
      <th>Type</th>
      <th>Default</th>
      <th>Valid Range</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>creative_fly_speed:max_allowed_multiplier</code></td>
      <td><code>Double</code></td>
      <td><code>10.0</code></td>
      <td><code>1.0 – 50.0</code></td>
      <td>Maximum flight multiplier builders are permitted to reach.</td>
    </tr>
    <tr>
      <td><code>creative_fly_speed:vertical_thrust_ratio</code></td>
      <td><code>Double</code></td>
      <td><code>1.0</code></td>
      <td><code>0.2 – 3.0</code></td>
      <td>Ratio of vertical climbing speed relative to horizontal speed.</td>
    </tr>
    <tr>
      <td><code>creative_fly_speed:enable_scroll_adjust</code></td>
      <td><code>Boolean</code></td>
      <td><code>true</code></td>
      <td><code>true / false</code></td>
      <td>Allows players to adjust flight speed via mouse scroll.</td>
    </tr>
    <tr>
      <td><code>creative_fly_speed:inertia_damping</code></td>
      <td><code>Double</code></td>
      <td><code>1.0</code></td>
      <td><code>0.0 – 1.0</code></td>
      <td>Damping factor for instant stopping upon key release.</td>
    </tr>
  </tbody>
</table>
<hr>
<h2>📖 In-Depth How-To &amp; Gameplay Playbook</h2>
<h3>Step 1: Installing for Singleplayer or Servers</h3>
<ol>
  <li>Install <strong>Fabric Loader</strong> and <strong>Fabric API</strong> for Minecraft 26.2+ / 26.3+.</li>
  <li>Place <code>creative-fly-speed-x.y.z+<version>.jar</code> into your <code>mods/</code> directory.</li>
  <li>If running a dedicated server, install it on the server as well to unlock high-speed server authorization.</li>
</ol>
<h3>Step 2: Navigating Large Creative Worlds</h3>
<ul>
  <li>Double-tap <code>Space</code> to enter creative flight.</li>
  <li>Hold <code>Left Alt</code> and scroll your mouse wheel forward: watch the action bar indicate <code>Fly Speed: 2.0x &rarr; 4.0x &rarr; 8.0x</code>.</li>
  <li>Press <code>W</code> to cross vast oceans and continents in seconds!</li>
  <li>When you reach your build site, hold <code>Left Alt</code> and scroll backward down to <code>0.2x</code> or <code>0.5x</code> to place glass, stairs, and fine details with pixel-perfect control.</li>
</ul>
<h3>Step 3: Admin World Plot Setup</h3>
<ul>
  <li>For servers hosting creative build contests, set <code>/gamerule creative_fly_speed:max_allowed_multiplier 5.0</code> to balance builder mobility with server chunk-generation performance.</li>
</ul>
<hr>
<h2>☕ Support &amp; Creator Community</h2>
<p>I am an independent solo developer creating lightweight, vanilla-enhancing mods that respect your time and game performance. If Creative Fly Speed accelerates your creativity, consider supporting future development:</p>
<p align="center">
<a href="https://ko-fi.com/rifaditya"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&amp;logo=ko-fi&amp;logoColor=white" alt="Support on Ko-fi"></a>
<a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
<a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>
<blockquote><p><strong>🇮🇩 Indonesian Local Payment Note:</strong> Indonesian supporters can also support my development work directly using local payment options (<strong>GoPay, OVO, Dana, QRIS, LinkAja</strong>) via <strong>Saweria</strong> or <strong>SocioBuzz</strong>!</p></blockquote>
<p>Join our official Discord community for live development updates, early test builds, and friendly support:</p>
<ul>
  <li>💬 <strong>Discord Community:</strong> <a href="https://discord.gg/EV99bgAFqb" target="_blank" rel="noopener">https://discord.gg/EV99bgAFqb</a></li>
</ul>
<hr>
<h2>📜 Metadata &amp; Permissions</h2>
<table>
  <thead>
    <tr>
      <th>Property</th>
      <th>Value</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Mod Name</strong></td>
      <td>Creative Fly Speed</td>
    </tr>
    <tr>
      <td><strong>Namespace / Mod ID</strong></td>
      <td><code>creative_fly_speed</code></td>
    </tr>
    <tr>
      <td><strong>License</strong></td>
      <td>GNU General Public License v3.0 (GPLv3)</td>
    </tr>
    <tr>
      <td><strong>Side Safety</strong></td>
      <td>Client &amp; Server (Vanilla Server Safe)</td>
    </tr>
    <tr>
      <td><strong>Source Code</strong></td>
      <td><a href="https://github.com/Rifaditya/Creative-Fly-Speed" target="_blank" rel="noopener">GitHub Repository</a></td>
    </tr>
    <tr>
      <td><strong>Issue Tracker</strong></td>
      <td><a href="https://github.com/Rifaditya/Creative-Fly-Speed/issues" target="_blank" rel="noopener">GitHub Issues</a></td>
    </tr>
  </tbody>
</table>
<blockquote><p><strong>📦 Modpack Permissions &amp; Distribution:</strong><br> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (<strong>Modrinth</strong> or <strong>CurseForge</strong>). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited. <br><br> <strong>⚖️ License &amp; Fork Guidelines (No Zero-Change Re-uploads):</strong><br> This project is open-source under the <strong>GNU GPLv3</strong>. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br> <strong>However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.</strong></p></blockquote>
<hr>
<div align="center">
<strong>Made with ❤️ for the Minecraft community</strong>
<em>Part of the Vanilla Outsider Collection</em>
</div>
