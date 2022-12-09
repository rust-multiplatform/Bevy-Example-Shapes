# How to properly 'fork' this template/example?

We have a [base template/example](https://github.com/rust-multiplatform/Bevy-Example-Shapes).  
In it, we defined the basics of our projects to keep them uniform across all other examples/templates, as well as developer tools like CI's (Continuous Integrations).

When using this example/template, we want to ensure that everyone is up-to-date and secure.
This is commonly done with **forks**.  
However, there is a problem: Within the same organization or namespace (e.g. user) you can't fork a repository when it already exists.
This means we would have to create a separate namespace for each example we provide.
However, there is a way around this issue.

## Normal forking (works just once per namespace)

On GitHub on our [base template/example](https://github.com/rust-multiplatform/Bevy-Example-Shapes) at the top right corner is a "Fork" button.
Simply press that, give your new repository a name and select the namespace and done.  
You've just forked our repository!
Every time we update the base repository, you will find a banner and button on your forked repository stating that the base got updated and that you can merge it into your fork.
**To stay up to date and avoid future problems we recommend to always merge!**

## Git-Native forking (works unlimited)

However, when working on a project internally (in the same namespace/organization) we can't easily fork as the project already exists there.  
Weird limitation, but we can get around it:

> Note that this also works outside of GitHub.  
> This is possible for every Git repository, no matter where it is hosted.  
> Even local repositories can use this.

First, we need to create a full copy (mirror) of the base:  

> Note, that the following steps are only required to be done by one person (e.g head-dev/team-lead) to merge changes from the base repository.
> Not every member of the project needs this!

1. Create a new empty repository in the namespace you want it to be in _or_ have an existing repository.
2. Clone your repository normally (`git clone <your git url> <folder name>`)
3. Add a secondary remote commonly called `upstream` with the base project url: `git remote add upstream https://github.com/rust-multiplatform/Bevy-Example-Shapes`
4. Now, using `git fetch --all` (or `git fetch upstream`) will update your mirror repository with the base projects changes.
5. With `git pull upstream (<branch>)` you can pull the changes from the base repository. This will automatically start a merge and may prompt you with merge conflicts if you've changed any of the files. Resolve those, commit the merge and you are done updating your fork/mirror!

Unfortunately, this is harder to automate as merge conflicts usually require user interaction.  
Furthermore, there is currently no way of checking (or getting a notification) _if_ the base updated, except for manually checking and/or pulling from upstream.

### Automation

To automate this process we could make a CI/GitHub Action that runs hourly or daily (or whenever) (note that on-push won't work since changes are happening on the base repository, not yours!) and does the latter steps automatically.  
However, this will fail if even a single merge conflict arises in the forked repository.  
This then would have to be solved manually.

## What is important to do after forking?

Here's a checklist:

- Licenses:
  - Check which license you want to use. We recommend dual-licensing but chose what ever fits you best.
  - Add your name(s) to the Copy-Right notices.
  - Update the `Cargo.toml` with the license of your choosing.
- README's:
  - Make notice of the base project template and/or the GitHub Organization.
  - Rename the title to your project name (also check for mentions inside the README's!).
  - Update CI URLs, otherwise your fork will reflect the CI Badges from the base template.
  - Update the goal & description of your project.
    - Also make sure to include screenshots of the goal for each platform (if applicable)
- CI's:
  - Enable/Disable whatever CI's you want to use:
    - Inside the organization all CI's should work effortlessly, you may need to enlist it manually though.
    - Outside the organization you may not have access to all CI's. You can disable CI's or remove them fully (note that this will create merge conflicts when updating from the base!).
    - You may also want to adjust your CI's based on for which platforms you are building. It's enough to build on one CI platform for all platforms.
- Cargo.toml:
  - For each `Cargo.toml` (shared & platform specific) there is a mention of the repository.
  - For each `Cargo.toml` there also is a notice about the license.
