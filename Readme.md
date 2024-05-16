To run the application please execute two following steps: 
1. Prepare JAR with:
   `mavn clean package`
2. Run the app with (example command):
   `java -jar cron-parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`