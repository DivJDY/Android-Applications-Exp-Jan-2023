import 'package:get/get.dart';
import 'package:academy_of_pop/views/pages/home_page.dart';
import 'package:academy_of_pop/views/pages/second_page.dart';


// Router
class RoutesClass {
  static String home = '/';
  static String secondScreen = "/secondScreen";

  static String getHomePage() {
    return home;
  }

  static String getSecondPage() {
    return secondScreen;
  }

  static List<GetPage> routes = [
    GetPage(
        name: home,
        page: () => const HomeScreen(),
        transition: Transition.fade,
        transitionDuration: const Duration(seconds: 1)),
    GetPage(
        name: secondScreen,
        page: () => const SecondScreen(),
        transition: Transition.fade,
        transitionDuration: const Duration(seconds: 1)),
  ];
}