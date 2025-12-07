# Raycast Android (Unofficial)

Android adaptation of the popular macOS and iOS app [Raycast](https://www.raycast.com/)

## Features

- Launcher for AI commands, snippets, quick links, apps, and contacts to take action with them.
- Keyboard for editing text with quick links, snippets, and AI commands.

## Motivation
Job application project for Raycast. As a devoted Raycast user on macOS, I want to join the team to help bring Raycast power to Android.

## Installation

Clone the project, add secret keys and build it locally:

```bash
git clone https://github.com/kerimabdy/raycast-android.git
cd raycast-android

touch secret.properties
// XAI_API_KEY={ api key }
// RAYCAST_SIGNATURE={ signature }
// RAYCAST_TOKEN={ token }

./gradlew installDebug
```