# Platform: WebAssembly

[![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_webassembly.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_webassembly.yml)
[![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes)

This is the platform-specific project for the platform WebAssembly.  
Make sure to check the shared crate as we depend on it.

## How does this work?

Rust is a cross-platform language that supports many different architectures and platforms.  
Building for Desktop Platforms (like Windows, Linux, macOS) is natively supported as long as the required tools are installed.
For Android, iOS and WebAssembly (WASM) we _"require"_ some additional tools to build.
In essence, we could do it without those tools but it would be much harder to do so.
Said tools commonly package our apps into .APK, .APP and .JS/WASM, link them against our library and make sure the entrypoint is called.

Inside `src/lib.rs` we have a public entrypoint defined:

```rust
pub fn entrypoint() {
    // Our cross-platform code here
}
```

Each platform calls this, while each platform itself has an entrypoint.  

Ideally, we **only** have our shared code.  
However, sometimes we need some very platform specific things that can only be done on said platform.
In this case we have _some_ non-shared/platform-specific code but overall this should only be true for very special cases as the Rust standard library works mostly the same on each platform/target.

## What does this crate do?

For WebAssembly we can't use the standard Rust-Entrypoint (`src/main.rs ::  fn main() { ... }`), but have to define a library (`src/lib.rs`) and have it have a **public** `wasm_entry` function:

```rust
use wasm_bindgen::prelude::*;

#[wasm_bindgen]
pub fn wasm_entry() {
    // OUR CODE HERE
}

```

> Note that we have to prefix the function with `#[wasm_bindgen]`.  
> This exports our function to JavaScript and can be called from there.  
> This is only needed for functions that are needed to be called from JavaScript, functions that are only called inside Rust won't need this.

Within the main function we call our entrypoint of the shared library.
Check out the shared crate for more on how this is working and what it is doing.

This is the most basic of examples: A simple `"Hello World"` or better yet: `"Hello from Rust!"` to the standard output.  
On Desktop platforms this will open a Terminal/Console printing out the text and exiting.  
For Android, iOS and WebAssembly this will be logged to LogCat, Device Logs and the Browser Console respectively.  

**Independent of the platform the app will _exit_ right after being done. Depending on the platform the window (console _or_ app) may close before you even see it.**  
On Desktop you can call the executable from a terminal either by using the executable in `target/(debug|release|<arch>)/platform_*(.exe)` or using the `cargo run --package platform_<platform>` command.
For Android, iOS and WebAssembly enable persistent logging and reopen the app/website.

## Building

|                         | Host: Windows                                                                                                                                                                                                                                                    | Host: Linux                                                                                                                                                                     | Host: macOS                                                                                                                                    |
| ----------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------- |
| **Target: Windows**     | ✅: [Visual Studio](https://visualstudio.com/)                                                                                                                                                                                                                    | 🔀: [MinGW](https://www.mingw-w64.org/)                                                                                                                                          | 🔀: [MinGW](https://www.mingw-w64.org/)                                                                                                         |
| **Target: Linux**       | ⚠️: [WSL](https://docs.microsoft.com/en-us/windows/wsl/) or VM or Docker                                                                                                                                                                                          | ✅: [GCC](https://gcc.gnu.org/) or [Clang](https://clang.llvm.org/)                                                                                                              | 🔀: Docker or VM                                                                                                                                |
| **Target: macOS**       | ⚠️: [Docker-OSX (inside WSL with Docker)](https://github.com/sickcodes/Docker-OSX) or [OSX-KVM (inside WSL or VM)](https://github.com/kholia/OSX-KVM) or [macOS-VirtualBox (inside/with WSL and/or MSYS2/MinGW)](https://github.com/myspaghetti/macos-virtualbox) | ⚠️: [Docker-OSX](https://github.com/sickcodes/Docker-OSX) or [OSX-KVM](https://github.com/kholia/OSX-KVM) or [macOS-VirtualBox](https://github.com/myspaghetti/macos-virtualbox) | ✅: [XCode](https://developer.apple.com/xcode/)                                                                                                 |
| **Target: Android**     | 🔀: [Android Studio](https://developer.android.com/studio/) or [Android CommandLine-Tools](https://developer.android.com/studio/#command-tools)                                                                                                                   | 🔀: [Android Studio](https://developer.android.com/studio/) or [Android CommandLine-Tools](https://developer.android.com/studio/#command-tools)                                  | 🔀: [Android Studio](https://developer.android.com/studio/) or [Android CommandLine-Tools](https://developer.android.com/studio/#command-tools) |
| **Target: iOS**         | ⚠️: [Docker-OSX (inside WSL with Docker)](https://github.com/sickcodes/Docker-OSX) or [OSX-KVM (inside WSL or VM)](https://github.com/kholia/OSX-KVM) or [macOS-VirtualBox (inside/with WSL and/or MSYS2/MinGW)](https://github.com/myspaghetti/macos-virtualbox) | ⚠️: [Docker-OSX](https://github.com/sickcodes/Docker-OSX) or [OSX-KVM](https://github.com/kholia/OSX-KVM) or [macOS-VirtualBox](https://github.com/myspaghetti/macos-virtualbox) | ✅: [XCode](https://developer.apple.com/xcode/)                                                                                                 |
| **Target: WebAssembly** | ✅: [Wasm-Pack](https://rustwasm.github.io/wasm-pack/installer/)                                                                                                                                                                                                  | ✅: [Wasm-Pack](https://rustwasm.github.io/wasm-pack/installer/)                                                                                                                 | ✅: [Wasm-Pack](https://rustwasm.github.io/wasm-pack/installer/)                                                                                |

✅ = Natively supported.  
🔀 = Cross-Compilation & Toolchain needed.  
⚠️ = Possible, but takes some more effort and/or special setups or VM to work.

Requirements:  

- Rust and Cargo is installed, preferably via [Rustup](https://rustup.rs/). Use the stable channel ideally.
- To build WASM binaries we need [Wasm-Pack](https://rustwasm.github.io/wasm-pack/installer/).
- To actually use the WASM binaries we also need a web-server or packer. E.g. NodeJS/NPM can be used, but a simple `index.html` can also be viewed inside every browser **without** a server.

Building is slightly different than using `cargo`, works roughly the same though:

Debug/Development Build:

```shell
wasm-pack build platform/webassembly/ --dev --package platform_webassembly
```

Release/Production Build:

```shell
wasm-pack build platform/webassembly/ --package platform_webassembly
```

> Note, that `wasm-pack` builds a release version **by default**.
> We have to supply `--dev` to get a debug/development version.

Build artifacts are stored inside `pkg/`, rather than `target/`.

Check out `wasm-pack build --help`; `wasm-pack` supports different targets e.g.: `bundler, nodejs, web, no-modules`.  
Use one fitting for your needs (`bundler` bundles it together, `nodejs` creates a ready-to-be-used nodejs module, `web` makes usage possible without NodeJS/Bundler and `no-modules` just makes the WASM module and bindings).

## Testing

There are no tests! `wasm-pack` does not support testing.  
We could still use `cargo` or make an NodeJS/NPM Module out of it and test it via `npm`.

## Running

Running WASM modules/WebAssembly isn't complicated, but requires some more work.  
First, follow the [build steps](#building).  

Next, create a website. This can be a simple `index.html` (easiest), a NodeJS website or even something like ReactJS.  
We will go with a simple `index.html` for simplicity:  

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>@Rust-Multiplatform - Base Project Templaet</title>
  </head>
  <body>
    <noscript>This page contains webassembly and javascript content, please enable javascript in your browser.</noscript>
    <script src="./platform_webassembly.js"></script>
  </body>
</html>
```

First have a line with `<noscript>` in your HTML, this will get triggered if there is **no** JavaScript support in the browser.  
Secondly, call the generated JavaScript file. This will invoke our Rust code.

You can of course modify your HTML to your liking, even add content to it.  
Ideally, you'd be doing that in Rust too with e.g. [web-sys](https://docs.rs/web-sys/0.3.35/i686-unknown-linux-gnu/web_sys/).  
However, this will **only** work for the WebAssembly Platform.
Check out the guides on [rustwasm.github.io](https://rustwasm.github.io) for more information about this.

Even better would be utilize HTML5 Canvases with e.g. WGPU.  
Though, this requires a lot more resources and code.

Alternatively, you can use Rust for everything else. Write your library code (e.g. REST API) in it, do some calculations, whatever you need you can do here!
