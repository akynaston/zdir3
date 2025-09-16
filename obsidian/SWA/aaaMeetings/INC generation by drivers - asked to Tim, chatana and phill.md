

Tim, Chaitanya, Phil,

During some recent driver walkthroughs, Ops has asked if our drivers can integrate with existing solutions, such as generating INCs whenever a situation that needs resolving comes up. I am looking to document the most desirable way to accomplish this. Below I describe what I'm looking for, and would appreciate your input.  Would you like a meeting to discuss this, or is a review below over email sufficient?


DETAILS:
If I encounter an issue in the IDtoMiro driver for example, such as having an expired token, I'll get back a specific error message. This is an issue that needs an incident created for it. I am aware of two possible ways to do this:


1 - Directly invoke a rest end point like the NotificationLoopback IDM driver with a useful payloadis doing now to an end point like: https://southwestdev.service-now.com/api/soai/terequest_new_prehire_and_termination/termination.

2 - Output a specific error message or string to the trace that can be 'scraped' and have an INC generated - such as IDtoMiro-ERR-0001-BAD-TOKEN along with an error message.

Are there other options? What is your preference for doing something like this?




