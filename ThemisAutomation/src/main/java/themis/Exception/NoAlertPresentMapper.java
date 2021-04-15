package themis.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;	
import org.openqa.selenium.NoAlertPresentException;

@Provider
public class NoAlertPresentMapper implements ExceptionMapper<NoAlertPresentException> {

	@Override
	public Response toResponse(NoAlertPresentException e) {
		// TODO Auto-generated method stub
		return Response.status(400).entity(e.getMessage()).build();
	
	}

}


/*ElementNotVisibleException	This type of Selenium exception occurs when an existing element in DOM has a feature set as hidden.
ElementNotSelectableException	This Selenium exception occurs when an element is presented in the DOM, but you can be able to select. Therefore, it is not possible to interact.
NoSuchElementException	This Exception occurs if an element could not be found.
NoSuchFrameException	This Exception occurs if the frame target to be switched to does not exist.
NoAlertPresentException	This Exception occurs when you switch to no presented alert.
NoSuchWindowException	This Exception occurs if the window target to be switch does not exist.
StaleElementReferenceException	This Selenium exception occurs happens when the web element is detached from the current DOM.
SessionNotFoundException	The WebDriver is acting after you quit the browser.
TimeoutException	Thrown when there is not enough time for a command to be completed. For Example, the element searched wasn't found in the specified time.
WebDriverException	This Exception takes place when the WebDriver is acting right after you close the browser.
ConnectionClosedException	This type of Exception takes place when there is a disconnection in the driver.
ElementClickInterceptedException	The command may not be completed as the element receiving the events is concealing the element which was requested clicked.
ElementNotInteractableException	This Selenium exception is thrown when any element is presented in the DOM. However, it is impossible to interact with such an element.
ErrorInResponseException	This happens while interacting with the Firefox extension or the remote driver server.
ErrorHandler.UnknownServerException	Exception is used as a placeholder in case if the server returns an error without a stack trace.
ImeActivationFailedException	This expectation will occur when IME engine activation has failed.
ImeNotAvailableException	It takes place when IME support is unavailable.
InsecureCertificateException	Navigation made the user agent to hit a certificate warning. This can cause by an invalid or expired TLS certificate.
InvalidArgumentException	It occurs when an argument does not belong to the expected type.
InvalidCookieDomainException	This happens when you try to add a cookie under a different domain instead of current URL.
InvalidCoordinatesException	This type of Exception matches an interacting operation that is not valid.
InvalidElementStateExceptio	It occurs when command can't be finished when the element is invalid.
InvalidSessionIdException	This Exception took place when the given session ID is not included in the list of active sessions. It means the session does not exist or is inactive either.
InvalidSwitchToTargetException	This occurs when the frame or window target to be switched does not exist.
JavascriptException	This issue occurs while executing JavaScript given by the user.
JsonException	It occurs when you afford to get the session when the session is not created.
NoSuchAttributeException	This kind of Exception occurs when the attribute of an element could not be found.
MoveTargetOutOfBoundsException	It takes place if the target provided to the ActionChains move() methodology is not valid. For Example, out of the document.
NoSuchContextException	ContextAware does mobile device testing.
NoSuchCookieException	This Exception occurs when no cookie matching with the given pathname found for all the associated cookies of the currently browsing document.
NotFoundException	This Exception is a subclass of WebDriverException. This will occur when an element on the DOM does not exist.
RemoteDriverServerException	This Selenium exception is thrown when the server is not responding because of the problem that the capabilities described are not proper.
ScreenshotException	It is not possible to capture a screen.
SessionNotCreatedException	It happens when a new session could not be successfully created.
UnableToSetCookieException	This occurs if a driver is unable to set a cookie.
UnexpectedTagNameException	Happens if a support class did not get a web element as expected.
UnhandledAlertException	This expectation occurs when there is an alert, but WebDriver is not able to perform Alert operation.
UnexpectedAlertPresentException	It occurs when there is the appearance of an unexpected alert.
UnknownMethodException	This Exception happens when the requested command matches with a known URL but and not matching with a methodology for a specific URL.
UnreachableBrowserException	This Exception occurs only when the browser is not able to be opened or crashed because of some reason.
UnsupportedCommandException	This occurs when remote WebDriver does n't send valid commands as expected.
*/