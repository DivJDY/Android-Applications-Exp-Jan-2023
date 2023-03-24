import 'package:logging/logging.dart';
import 'package:flutter/material.dart';

var count = 0;

void logEvents() async {
  count++;
  final log = Logger('Sentry_flutter Log With Button');

  log.info('a breadcrumb!');

  try {
    // throw Exception();
    log.severe(
        'testing an log with version Sentry_flutter Log (Elevated Button) with Alert dailog ==> click count = $count');
  } catch (error, stackTrace) {
    log.severe('an error! with an message for testing when click the button',
        error, stackTrace);
  }
}

class Logging extends StatelessWidget {
  const Logging({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Track Events'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: const Text('Track Logging'),
                content:
                const Text('Tracking the events when click the Submit Button'),
                actions: <Widget>[
                  TextButton(
                    onPressed: () {
                      print('hii');
                      logEvents();
                      Navigator.of(ctx).pop();
                    },
                    child: Container(
                      color: Colors.white,
                      padding: const EdgeInsets.all(14),
                      child: const Text("Submit"),
                    ),
                  ),
                  TextButton(
                    onPressed: () {
                      Navigator.of(ctx).pop();
                    },
                    child: Container(
                      color: Colors.white,
                      padding: const EdgeInsets.all(14),
                      child: const Text("Close"),
                    ),
                  ),
                ],
              ),
            );
          },
          child: const Text("Log"),
        ),
      ),
    );
  }
}