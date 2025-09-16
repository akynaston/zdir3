2/20/2024 1:36:54 PM

/**
 * Get version of Rhino JavaScript interpreter
 * @since 1.2.8
 * @returns {string} version
 */
function getRhinoVersion() { // eslint-disable-line no-unused-vars
    var currentContext = Packages.com.novell.soa.script.mozilla.javascript.Context.getCurrentContext();
    return (currentContext.getImplementationVersion());
}