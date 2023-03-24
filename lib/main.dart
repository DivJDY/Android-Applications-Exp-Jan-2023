import 'package:academy_of_pop/views/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:sentry_logging/sentry_logging.dart';
import 'package:sentry/sentry.dart';

// import 'package:academy_of_pop/sentry/logging.dart';
import 'package:academy_of_pop/routes/routes.dart';

Future<void> main() async {
  await Sentry.init((options) {
    options.dsn =
        'https://57b9f05af3244127a3533dabf73ca0ce@o4504637316530176.ingest.sentry.io/4504638445846528';
    options.addIntegration(LoggingIntegration());
    options.release = 'Sentry@1.0.0';
    options.environment = 'debug';
  },
      appRunner: () => runApp(GetMaterialApp(
          debugShowCheckedModeBanner: false,
          theme: AppTheme.lightTheme,
          darkTheme: AppTheme.darkTheme,
          themeMode: ThemeMode.system,
          title: 'Academy of Pop',
          initialRoute: RoutesClass.getHomePage(),
          getPages: RoutesClass.routes)));
}
