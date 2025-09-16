10/25/2024 2:22:53 PM

The drv.allowtracing GCV logic is reversed: right now, drv.allowtracing = true means is-sensitive is set to 'true' which  has the opposite effect, and doesn't allow tracing! A better name for this GCV would be 'drv.hideSensitive' so that it would match the is-sensitive functionality -> drv.hideSensitive = is-sensitive = true  = hides the trace.