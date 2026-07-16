# Audio Suite Automation Framework

Selenium + TestNG + ExtentReports automation framework for the **TSL Audio Suite**
(Telesuite – ENS.Conference.IVRS, v1.2.0) web application, built in the exact same
structure/format as the existing `CallAuditAutomation` framework.

## What stayed the same (as requested)

- **Project layout**: `src/main/java` (base, config, reports, utils, pages) and
  `src/test/java` (tests) + `src/test/resources` (config.properties, log4j2.xml).
- **Reporting stack**: ExtentReports v5 (`ExtentSparkReporter`, STANDARD theme),
  wired through `ExtentManager` + `BaseClass` + `ListenerUtlity` exactly like the
  original — only the report title/name and app system-info were updated for
  Audio Suite (`report.path=test-output/ExtentReport/AudioSuiteReport.html`).
- **Logging**: identical `log4j2.xml` (Console + rolling file appender at
  `logs/Automation.log`), same `LogUtil` wrapper.
- **Utilities**: `WaitUtil`, `JavaUtility`, `RandomDataUtil`, `ScreenshotUtil`,
  `ExcelUtil` carried over unchanged in behavior (package renamed to
  `com.audiosuite.*`).
- **pom.xml**: same dependencies/versions (Selenium 4.18.1, TestNG 7.9.0,
  ExtentReports 5.1.1, WebDriverManager 5.7.0, POI 5.2.5, log4j 2.25.1) and same
  Surefire/testng.xml wiring.
- **Test class pattern**: one stub Test class per module extending `BaseClass`,
  same as `LoginTest`/`ReportsTest` etc. in the original — ready for you to fill
  in `@Test` methods using the Page Objects below.

## One small fix applied

`ConfigReader.get(String)` in the original project always returned `null`
(dead stub), which would have made `ExtentManager` (`ConfigReader.get("report.path")`,
`get("env")`, `get("browser")`) throw a `NullPointerException` at runtime. It now
correctly reads from `config.properties`, same as `getConfigData(...)`.

## What's new: Page Objects for Audio Suite

All Page Objects were derived from `TSL_Audio_Suite_GUI_Users_Manual (Classic Format).docx`
and live in `com.audiosuite.pages`:

| Page Object            | Manual section covered                                   |
|-------------------------|----------------------------------------------------------|
| `LoginPage`             | Login Page, Branch Selection Dialog, Forgot Password, Set Password |
| `DashboardPage`         | Dashboard/Main Page (header, nav panel, duration filter, Voice/WhatsApp tabs) |
| `EmergencyPage`         | Emergency Page (Emergency/Live/Completed tabs, actions, trigger via GUI) |
| `NewEmergencyPage`      | New Emergency Page (schedule creation, DID/IVRS/voice file, participants, import) |
| `RecordingsPage`        | Recordings Page (Play Messages / ENS Voice Files tabs) |
| `BroadcastPage`         | Broadcast Page (All/Scheduled/Running/Completed, suspend/pause/resume/repeat) |
| `NewBroadcastPage`      | New Broadcast Page (schedule + IVR voice file mapping, participants) |
| `ConferencePage`        | Conference Page (All/Scheduled/Running/Completed, launch/view/repeat) |
| `StatusPage`            | (Live) Status Page — call/mute/disperse/add member/settings/status bar |
| `NewConferencePage`     | New Conference Page (schedule, options, participants, recurrence dialog) |
| `UsersPage`             | Users Page (list, add/edit/delete, license-limit disabled state) |
| `ContactPage`           | Contact Page (list, add/edit/delete, import/export, filters) |
| `ReportsPage`           | Reports Page (duration/app/CLI/location/report type/DID → Show Report) |
| `RolesPage`             | Roles Page (permission matrix, add/edit/delete role) |
| `SettingsPage`          | Settings Page (ENS / Voice Broadcast / Conference → General, Chairperson, Outbound Call) |
| `CLILocationPage`       | CLI Location Page (CLI–Location–VoiceFile mapping, import/export) |

## Note on locators

The manual describes *behavior*, not DOM structure/HTML ids, so locators in each
Page Object (`By.id(...)`, `By.cssSelector(...)`, `By.xpath(...)`) are
**placeholders following a consistent naming convention** (e.g. `emergencyName`,
`.add-emergency-icon`, `.delete-icon`). Once you have access to the real Audio
Suite DOM, update the `By` locator constants at the top of each Page Object —
the method names/public API can stay the same so existing test code won't break.

## Next steps

1. Point `base.url` in `src/test/resources/config.properties` to your Audio
   Suite QA environment.
2. Update locators in `src/main/java/com/audiosuite/pages/*.java` against the
   real application DOM.
3. Fill in `@Test` methods in `src/test/java/com/audiosuite/tests/*.java`,
   using the Page Objects (e.g. `new LoginPage(driver).login(email, password)`).
4. Run with `mvn test` (uses `testng.xml`) — ExtentReports output will be at
   `test-output/ExtentReport/AudioSuiteReport.html`, logs at `logs/Automation.log`.
