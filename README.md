## Jetpack Compose LazyColumn Bug

This repository just contains a demo that reproduces a bug in Jetpack Compose LazyColumn.

### Reference Issue 

https://issuetracker.google.com/issues/267642562

### Bug Details

When a `View` wrapped by an `AndroidView` composable sets its visibility to `GONE` and is contained within a `LazyColumn` item, the View's content disappears, but the `LazyColumn` item row doesn't collapse or disappear. The `LazyColumn` item row keeps the same height as the `AndroidView` Composable.

This problem doesn't occur with Composables.

To reproduce the bug just build and deploy.