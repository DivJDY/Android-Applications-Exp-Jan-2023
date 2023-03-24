import 'package:flutter/material.dart';

class AppTheme {
  static double mediumFontSize = 16.0;
  static ThemeData lightTheme = ThemeData(
    fontFamily: 'Roboto',
    // primarySwatch: Colors.grey,
    // primarySwatch: const MaterialColor(0xFFFFFE200, <int, Color>{
    //   50: Color(0x33FFE200),
    //   100: Color(0x33FFE200)
    // }),
    // primaryColor: Color(0xFF5FAFE2),
    // primarySwatch: Colors.grey,
    brightness: Brightness.light,
    scaffoldBackgroundColor: Colors.white70,

    //App bar theme
    // appBarTheme: const AppBarTheme(
    //   color: Color(0xFF1E1E1E),
    //   iconTheme: IconThemeData(
    //     color: Colors.white,
    //   ),
    // ),

    //Color schema
    // colorScheme: const ColorScheme.light(
    //   primary: Color(0xFFFFFFFF),
    //   onPrimary: Color(0xFFFFFFFF),
    //   primaryVariant: Colors.white38,
    //   secondary: Color(0xFF5FAFE2),
    // ),

    cardTheme: const CardTheme(
      color: Color(0xFF232326),
    ),

    buttonTheme: const ButtonThemeData(buttonColor: Colors.deepOrange),

    iconTheme: const IconThemeData(color: Colors.white),

    textTheme: const TextTheme(
      headlineMedium:  TextStyle(
          color: Color(0xFF5FAFE2), fontWeight: FontWeight.bold),
      bodyLarge:  TextStyle(
          color: Color(0xFF232326), fontWeight: FontWeight.bold),
      bodyMedium:  TextStyle(
          color: Color(0xFFFF4EDE), fontWeight: FontWeight.bold),
      // subtitle2: const TextStyle(
      //   color: Colors.white,
      //   fontSize: 20.0,
      // ),
      // subtitle1: const TextStyle(
      //   color: Colors.white70,
      //   fontSize: 18.0,
      // ),
    ),
  );

  static ThemeData darkTheme = ThemeData(
    fontFamily: 'Roboto',
    // primarySwatch: Colors.yellow,
    brightness: Brightness.dark,

    scaffoldBackgroundColor: Colors.greenAccent,

    //App bar theme
    // appBarTheme: const AppBarTheme(
    //   color: Color(0xFF1E1E1E),
    //   iconTheme: IconThemeData(
    //     color: Colors.white,
    //   ),
    // ),

    //Color schema
    // colorScheme: const ColorScheme.light(
    //   primary: Color(0xFFFFFFFF),
    //   onPrimary: Color(0xFFFFFFFF),
    //   // primaryVariant: Colors.white38,
    //   secondary: Color(0xFF5FAFE2),
    // ),

    cardTheme: const CardTheme(
      color: Color(0xFFFFFFFF),
    ),

    buttonTheme: const ButtonThemeData(
      textTheme: ButtonTextTheme.normal,
      highlightColor: Color(0xFF5FAFE2),
    ),
    buttonBarTheme: const ButtonBarThemeData(
      buttonTextTheme: ButtonTextTheme.normal,
    ),

    iconTheme: const IconThemeData(color: Colors.black),

    textTheme: TextTheme(
      headlineMedium:
          const TextStyle(color: Colors.blue, fontWeight: FontWeight.bold),
      bodyMedium: TextStyle(
          color: const Color(0xFFFFFFFF),
          fontWeight: FontWeight.w600,
          fontSize: mediumFontSize),
      bodyLarge: const TextStyle(
          color: Color(0xFF232326), fontWeight: FontWeight.w600),
    ),
  );
}
