import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:logging/logging.dart';
import 'package:academy_of_pop/controllers/count_controller.dart';
import 'package:academy_of_pop/routes/routes.dart';

var count = 0;

void logEvents() async {
  count++;
  final log = Logger('Sentry_flutter Log With Button In Home Page');

  log.info('a breadcrumb!');

  try {
    // throw Exception();
    log.severe(
        'testing an log with version Sentry_flutter Log (Elevated Button) with Alert ==> click count = $count');
  } catch (error, stackTrace) {
    log.severe('an error! with an message for testing when click the button',
        error, stackTrace);
  }
}

class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    IconData iconLight = Icons.settings;
    var controller = Get.put(HomeController());

    return Scaffold(
      appBar: AppBar(
        title: const Text('Home Screen'),
      ),
      floatingActionButton: FloatingActionButton.small(
        onPressed: () {
          showDialog(
            context: context,
            builder: (ctx) => AlertDialog(
              title: const Text('System Theme'),
              content:  Text(
                  '${Theme.of(context).brightness}'),
              actions: <Widget>[
                TextButton(
                  onPressed: () {
                    Navigator.of(ctx).pop();
                  },
                  child: Container(
                    color: Colors.white,
                    padding: const EdgeInsets.all(14),
                    child: Text("Close",
                        style: Theme.of(context).textTheme.bodyLarge),
                  ),
                ),
              ],
            ),
          );
        },
        child: Icon(
          iconLight,
          color: Theme.of(context).iconTheme.color,
        ),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Obx(
              () => Text(
                'This is value ${controller.counter.value}',
                style: Theme.of(context).textTheme.headlineMedium,
              ),
            ),
            const Padding(padding: EdgeInsets.all(10)),
            ElevatedButton(
              onPressed: () {
                showDialog(
                  context: context,
                  builder: (ctx) => AlertDialog(
                    title: const Text('Track Logging'),
                    content: const Text(
                        'Tracking the events when click the Submit Button'),
                    actions: <Widget>[
                      TextButton(
                        onPressed: () {
                          // print('hi');
                          logEvents();
                          Navigator.of(ctx).pop();
                        },
                        child: Container(
                          color: Colors.white,
                          padding: const EdgeInsets.all(14),
                          child: Text("Submit",
                              style: Theme.of(context).textTheme.bodyLarge),
                        ),
                      ),
                      TextButton(
                        onPressed: () {
                          Navigator.of(ctx).pop();
                        },
                        child: Container(
                          color: Colors.white,
                          padding: const EdgeInsets.all(14),
                          child: Text("Close",
                              style: Theme.of(context).textTheme.bodyLarge),
                        ),
                      ),
                    ],
                  ),
                );
              },
              child: const Text(
                "Log",
                // style: TextStyle(fontWeight: FontWeight.bold),
              ),
            ),
            ElevatedButton(
                onPressed: () {
                  controller.incrementValue();
                  print("Color, ${Theme.of(context).textTheme.bodyLarge}");
                },
                child: Text(
                  "Increase Value",
                  // style: TextStyle(
                  //     color: Colors.purple, fontWeight: FontWeight.bold),
                  style: Theme.of(context).textTheme.bodyLarge,
                )),
            // ElevatedButton(
            //     onPressed: () {
            //       Get.toNamed(RoutesClass.getSecondPage());
            //     },
            //     child:  Text(
            //       "Change Screen",
            //       // style: TextStyle(
            //       //     color: Colors.deepPurpleAccent,
            //       //     fontWeight: FontWeight.bold),
            //
            //       style: Theme.of(context).textTheme.bodyLarge,
            //     )
            // ),
            OutlinedButton(
                onPressed: () {
                  Get.toNamed(RoutesClass.getSecondPage());
                },
                // style: OutlinedButton.styleFrom(backgroundColor: Colors.white),
                child: Text(
                  'Change Screen',
                  // style: TextStyle(color: Colors.teal, fontWeight: FontWeight.w900),

                  style: Theme.of(context).textTheme.bodyMedium,
                )),
          ],
        ),
      ),
    );
  }
}
