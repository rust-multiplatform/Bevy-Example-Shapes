#![allow(clippy::all)]

use shared::entrypoint;

#[cfg(test)]
mod tests;

#[no_mangle]
fn android_main() {
    entrypoint();
}
