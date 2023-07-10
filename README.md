## Idea:
The primary concept revolves around demonstrating the process of creating a functional application that can be utilized by others. A series of posts are provided, detailing the step-by-step instructions for its development.

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
