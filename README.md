## Idea:
The primary concept revolves around demonstrating the process of creating a functional application that can be utilized by others.

## MVP Scope:
The minimum viable product (MVP) aims to allow users to subscribe to specific post groups and receive notifications via a Telegram bot whenever new posts related to their subscribed groups are published.

## Functionality:
Based on the MVP Scope, the following features can be defined:

- Telegram User can subscribe to groups of posts.
- Telegram User can view the list of group subscriptions they have.
- Telegram User can unsubscribe from specific groups of posts.
- Telegram User can choose to deactivate the bot and stop receiving notifications.
- Telegram User can restart the process of receiving notifications.
#
  ### The workflow of finding new posts and send them to subscribers:
  ![The workflow of finding new posts and send them to subscribers](https://raw.githubusercontent.com/Larisa-Pomidor/javabot/master/find-new-posts-workflow.png)

## Technological stack
- SpringBoot as a skeleton framework
- Spring Scheduler as a task manager
- MySQL database as a database for saving user and subscription info
- Flyway database migration tool
- Telegram-bot SpringBoot starter
- Spring Data starter
- Unirest - lib for working with REST calls

## Local development
For local development and testing, use docker-compose-test.yml. Run command:

docker-compose -f docker-compose-test.yml up
Next step, is to run SpringBoot app with configured Edit Configuration in which two env vars are provided:

bot.token=${BOT_TOKEN};bot.username=${BOT_USERNAME}

And add VM Options:

-Dspring.profiles.active=test 

With these configurations - run SpringBoot main method.

## Screenshots
![java-bot-screenshot-1](https://raw.githubusercontent.com/Larisa-Pomidor/javabot/master/java-bot-1.jpg)
![java-bot-screenshot-2](https://raw.githubusercontent.com/Larisa-Pomidor/javabot/master/java-bot-2.jpg)
![java-bot-screenshot-3](https://raw.githubusercontent.com/Larisa-Pomidor/javabot/master/java-bot-3.jpg)
