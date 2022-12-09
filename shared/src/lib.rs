#![allow(clippy::all)]

#[cfg(test)]
mod tests;

mod greet_people_plugin;
use greet_people_plugin::*;

use bevy::prelude::*;

pub fn entrypoint() {
    App::new()
        // Add default plugins
        // Includes things like UI, Input, and Windowing
        .add_plugins(DefaultPlugins)
        // Add our own plugin
        .add_plugin(GreetPeoplePlugin)
        .run();
}
