# Rust Multi-Platform: Bevy Template

[![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_android.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_android.yml)
[![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_ios.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_ios.yml)
[![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_linux.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_linux.yml)
[![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_macos.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_macos.yml)
[![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_windows.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_windows.yml)

> ⚠️ THIS IS A TEMPLATE. ⚠️

This project is supported by the following platforms:

- ✅ Platform: Windows
- ✅ Platform: Linux
- ✅ Platform: macOS
- ✅ Platform: Android
- ✅ Platform: iOS
- ✅ Platform: WebAssembly (⚠️ Only the WASM & JS side, still needs a web-server or bundler and HTML/CSS part)

To use this project simply fork it (button in top right corner) into your own namespace.
If you need some more advanced setup check out the [forking guide](FORKING.md).
We also include a checklist for [what to do after forking](FORKING.md#what-is-important-to-do-after-forking).

## Licenses

This project is dual licensed in Rust's fashion:

- [MIT License](https://spdx.org/licenses/MIT.html)
- [Apache License 2.0](https://spdx.org/licenses/Apache-2.0.html)

For your own project you can chose whichever fits you better.
For templates/examples we recommend to also dual-licensing.

## Credits

Huge thanks to the team behind the [Bevy Engine](https://bevyengine.org/) ❤️!

## Performance & Optimizations

To best utilize the [Bevy Engine](https://bevyengine.org/) follow [their guide](https://bevyengine.org/learn/book/getting-started/setup/).

**This is highly dependant on the development platform and does NOT affect the target binaries.**

## Project layout

| Folder                                         | Description                                                                                                                         | GitHub Actions                                                                                                                                                                                                                  | Coverage                                                                                                                                                                              |
| ---------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ./                                             | Workspace root; `Cargo.toml` contains all project folders (internal crates)                                                         |                                                                                                                                                                                                                                 |                                                                                                                                                                                       |  |
| [platform/](platform/)                         | Platform projects root. Contains every platform this demonstration is supported on incl. instructions on how to build and use them. |                                                                                                                                                                                                                                 |                                                                                                                                                                                       |
| [platform/android/](platform/android/)         | Contains the Android platform project and instructions on how to build this project for Android and run it.                         | [![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_android.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_android.yml)         | [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes) |
| [platform/ios/](platform/ios/)                 | Contains the iOS platform project and instructions on how to build this project for iOS and run it.                                 | [![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_ios.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_ios.yml)                 | [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes) |
| [platform/linux/](platform/linux/)             | Contains the Linux platform project and instructions on how to build this project for Linux and run it.                             | [![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_linux.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_linux.yml)             | [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes) |
| [platform/macos/](platform/macos/)             | Contains the macOS platform project and instructions on how to build this project for macOS and run it.                             | [![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_macos.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_macos.yml)             | [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes) |
| [platform/windows/](platform/windows/)         | Contains the Windows platform project and instructions on how to build this project for Windows and run it.                         | [![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_windows.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_windows.yml)         | [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes) |
| [platform/webassembly/](platform/webassembly/) | Contains the WebAssembly platform project and instructions on how to build this project for Websites and run it.                    | [![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_webassembly.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/platform_webassembly.yml) | [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes) |
| [shared/](shared/)                             | Contains the **shared** code between **all** projects.                                                                              | [![Rust](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/shared.yml/badge.svg)](https://github.com/rust-multiplatform/Bevy-Example-Shapes/actions/workflows/shared.yml)                             | [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes) |

> Note that some pipelines don't cover all platforms/projects, but are building a specific project like `platform_linux`.

To break this down:
The [shared/](shared/) folder contains our **cross/multi-platform code**.
99.9% of what we do in this project will happen there.

Each of the projects inside [platform/](platform/) are representing a **platform specific project**.
In most cases, like for Windows, Linux and macOS, there is nothing else to do but call our shared code and compile a **binary**.
However, on certain platforms, like Android and iOS, we have to use some special commands and tools to get an e.g. .APK (Android) or .APP (iOS) file.
Furthermore, on those systems resources/assets may need to be specially loaded and their `Cargo.toml` will be much more extensive.
Simply said: For those special platforms we will use some cargo extensions which will automatically generate a native project in the background. Values from `Cargo.toml` will be used to generate those.

**Please check the `README.md` inside each platform to see how each platform is build, run and what you will need to do so.**

## Targets & Architectures

This project is aiming to work across all platforms **and targets**.
All **Tier 1** targets are tested in CI's of this repository.
Additionally, _some_ **Tier 2** targets are tested.

However, this should work on all targets. If you find an issue please report it.

[Rust's Tier Policies](https://doc.rust-lang.org/rustc/target-tier-policy.html)
[Rust's Platform Support & Targets](https://doc.rust-lang.org/rustc/platform-support.html)

## Building & Running

**Building & Running all projects at once only works if your host platform has all required packages installed.**
**Unfortunately, do to Apple's restrictions, macOS and iOS platforms can _only_ be build on macOS.**
**This also means that macOS is the only host platform that can build _all_ platforms at once.**

However, we can build and run individual parts (`packages`) matching our host platform and we can use a combination of cross-compilation, Docker and/or Virtual Machines (VM) to build everything on one host platform.

Host (top) vs. Target (left) compatibility matrix:

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

Building can be done via:

```shell
cargo build --package <package>
```

Or run it directly (running will build the project beforehand!):

```shell
cargo run --package <package>
```

If there are tests present for the project, we can test them:

```shell
cargo test --package <package>
```

Or check if the project configuration is valid & build-able:

```shell
cargo check --package <package>
```

> Note: Adding `--release` to either of the commands will build a release version, instead of a debug version.

**Do note that some platforms (like iOS and Android) require special tools and `cargo` extensions to properly build.**
While we could do that step manually, it is much more convenient and easier to use this way.
Check the `README.md` of a platform to learn more about requirements and tools.

Since we can't build for all target platforms on a single host platform (without major modification; see above), the `--package <package>` part is very important.
Simply replace `<package>` with the package name inside the `Cargo.toml` to build it.
Names commonly will be `platform_<platform>` for platform-specific packages (e.g. `platform_windows` or `platform_ios`) or `shared` for the shared code.
In case multiple shared projects are present, check their `Cargo.toml` for their name (commonly: folder name).

However, since we share most of our code on all target platforms, we only really need to validate the code working on **one platform** (ideally your host platform for best performance or main target platform).
Only rarely should we need platform-specific code which, if it exists, needs to be tested.
Though, a continuous integration pipeline (CI) can take care of that for you mostly!
Check [Continuous Integration](#Continuous-Integration) for more.

## Continuous Integration

This project utilizes the GitHub Actions CI (= Continuous Integration) to showcase how to build for all platforms.
For most platforms we just need a runner on the target platform (Windows, Linux or macOS) and install Rust.
This can be simply done by following [rustup.rs](https://rustup.rs/) (check the [other install options](https://rust-lang.github.io/rustup/installation/other.html) for automatically installing inside an CI).
Something like:

```shell
curl https://sh.rustup.rs -sSf | sh -s -- --default-toolchain stable --profile full -y
```

should work for most platforms.

Note that we _may_ need more tools installed depending on the CI provider and platform.
Check the host <-> target matrix at [Building & Running](#Building-&-Running)

Additionally, often we have to `source` the profile changes. Something like:

```shell
source $HOME/.cargo/env
```

Furthermore, we have templates for many other CI platforms if you prefer those.

> Please note, that some CI platforms only showcase how to build a single platform (such as `platform_linux`). This is done to save on costs and time.
> 
> Furthermore, that if just one CI platform is failing, it is most likely linked to a plan or build credit issue on said platform.
> GitHub Actions is **NOT** limited for open source repositories.
> If GitHub Actions succeed, all other CI platforms _should_ succeed as well.

List of CI Examples/Templates:

- [Rust-Multiplatform / CircleCI Example](https://github.com/rust-multiplatform/CI-Example-CircleCI)
- [Rust Multiplatform / TeamCity Example](https://github.com/rust-multiplatform/CI-Example-TeamCity)
- [Rust Multiplatform / GitLab Example](https://github.com/rust-multiplatform/CI-Example-GitLab-CI)
- [Rust Multiplatform / BItBucket Example](https://github.com/rust-multiplatform/CI-Example-BitBucket-Pipelines)
- [Rust Multiplatform / Travis Example](https://github.com/rust-multiplatform/CI-Example-Travis)
- [Rust Multiplatform / Azure DevOps Example](https://github.com/rust-multiplatform/CI-Example-Azure-Pipelines)
- [Rust Multiplatform / AppVeyor Example](https://github.com/rust-multiplatform/CI-Example-AppVeyor)

## Coverage

A combination of [grcov](https://github.com/mozilla/grcov) and [codecov.io](https://codecov.io) is used to provide code-to-test coverage.  
**Please note that it is impossible to reach 100% coverage on some platforms as e.g. bindgen-code (i.e. dynamically generated code / macros) is NOT covered by `grcov` and certain platform specific tools (like `cargo-apk`) generate additional code that also is NOT included in the coverage.**

Test-to-Code coverage status: [![codecov](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graph/badge.svg?token=XpGvuQVirP)](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes)

Below are several charts showing/highlighting the distribution of **all platforms**.

### Sunburst

![Sunburst](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graphs/sunburst.svg?token=XpGvuQVirP)

### Grid

![Grid](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graphs/tree.svg?token=XpGvuQVirP)

### Icicle

![Icicle](https://codecov.io/gh/rust-multiplatform/Bevy-Example-Shapes/branch/main/graphs/icicle.svg?token=XpGvuQVirP)

## Contributing & Getting Help

We welcome any help we get and try to answer questions as good as possible!
Generally speaking, please open an [issue here on GitHub](issues/new) or contact me directly.
No matter the problem or question.

In case you've got an idea/request for an example/template, please do open an [issue here on GitHub](issues/new).

Want to add your own example/template project to the organization and use our CI's?
Please open an [issue here on GitHub](issues/new).
