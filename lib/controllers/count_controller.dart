import 'package:get/get.dart';

//Increment controller
class HomeController extends  GetxController{
  var counter = 0.obs;

  incrementValue() {
    counter++;
  }

  decrementValue() {
    counter--;
  }
}
