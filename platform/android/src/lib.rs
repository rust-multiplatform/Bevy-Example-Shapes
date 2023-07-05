#![allow(clippy::all)]

#[cfg(target_os = "android")]
use android_activity::{AndroidApp, InputStatus, MainEvent, PollEvent};

#[cfg(target_os = "android")]
use shared::entrypoint;

#[cfg(test)]
#[cfg(target_os = "android")]
mod tests;

#[no_mangle]
#[cfg(target_os = "android")]
fn android_main(app: AndroidApp) {
    #[cfg(debug_assertions)]
    android_logger::init_once(
        android_logger::Config::default().with_max_level(log::LevelFilter::Debug),
    );
    #[cfg(not(debug_assertions))]
    android_logger::init_once(
        android_logger::Config::default().with_max_level(log::LevelFilter::Debug),
    );

    loop {
        app.poll_events(
            Some(std::time::Duration::from_millis(500)), /* timeout */
            |event| {
                match event {
                    PollEvent::Wake => {
                        log::info!("Early wake up");
                    }
                    PollEvent::Timeout => {
                        entrypoint();
                    }
                    PollEvent::Main(main_event) => {
                        log::info!("Main event: {:?}", main_event);
                        match main_event {
                            MainEvent::Destroy => {
                                return;
                            }
                            _ => {}
                        }
                    }
                    _ => {}
                }

                app.input_events(|event| {
                    log::info!("Input Event: {event:?}");
                    InputStatus::Unhandled
                });
            },
        );
    }
}
