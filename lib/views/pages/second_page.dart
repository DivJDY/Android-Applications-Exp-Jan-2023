import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:academy_of_pop/controllers/count_controller.dart';


// Second Screen
class SecondScreen extends StatelessWidget {
  const SecondScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var controller = Get.find<HomeController>();
    return Scaffold(
      // backgroundColor: Colors.brown,
      appBar: AppBar(
        title: const Text('Second Screen'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Obx(() => Text('Counter Value :  ${controller.counter.value}',
              // style: const TextStyle(
              //   color: Colors.black,
              //   fontSize: 30.00,
              //   fontWeight: FontWeight.bold,
              // ),
              style: Theme.of(context).textTheme.bodyMedium,
            ),

            ),
            const Padding(padding: EdgeInsets.all(5)),
            ElevatedButton(
                onPressed: () {
                  controller.decrementValue();
                },
                child: Text("Decrement Value", style: Theme.of(context).textTheme.bodyLarge,)),
          ],
        ),
      ),
    );
  }
}