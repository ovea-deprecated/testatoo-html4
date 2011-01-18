/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.html4.element;

import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.core.ComponentException;
import org.testatoo.core.component.Component;
import org.testatoo.core.nature.Container;

import static org.testatoo.cartridge.html4.element.HtmlElementType.Form;

/**
 * This class allows the testing of the "form" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-FORM"> form specification </a>
 */

public final class Form extends Component implements Coreattrs, I18n, Container {

    private HtmlEvaluator evaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "form" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "form" element
     * @throws ComponentException if the given id does not correspond to a "form" element
     */
    public Form(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Form) {
            throw new ComponentException("The component with id=" + id + " is not a " + Form + " but a " + evaluator.htmlElementType(id));
        }
    }

    /**
     * @see CoreAttributeSupport
     */
    public String classname() {
        return coreAttributeSupport.classname(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String style() {
        return coreAttributeSupport.style(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String title() {
        return coreAttributeSupport.title(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public String language() {
        return i18nAttributeSupport.language(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public Direction direction() {
        return i18nAttributeSupport.direction(this);
    }

    /**
     * To know if the form contains all the given components.
     *
     * @param components components we want to know if contained in the form
     * @return True if all the components is contained in the form
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the action attribute of the form.
     * Action is used to specify where the form is sent to. It must take the form of a URI.
     *
     * @return the action attribute of the form
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-action">W3C recommendation</a>
     */
    public String action() {
        return evaluator.attribute(id(), Attribute.action);
    }

    /**
     * To reset the form
     */
    public void reset() {
        evaluator.reset(this);
    }

    /**
     * To submit the form
     */
    public void submit() {
        evaluator.submit(this);
    }

    /**
     * To get the method attribute of the form (get or post).
     *
     * @return the method attribute of the form
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-method">W3C recommendation</a>
     */
    public Method method() {
        return attributeSupport.method(this);
    }

    /**
     * To get the enctype attribute of the form (when method is post).
     *
     * @return the enctype attribute of the form
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-enctype">W3C recommendation</a>
     */
    public String enctype() {
        return attributeSupport.enctype(this);
    }

    /**
     * To get the accept attribute of the form.
     * Accept is used to specify which file-types should be accepted. This is a comma-separated list of MIME types.
     *
     * @return the accept of the form
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accept">W3C recommendation</a>
     */
    public String accept() {
        return attributeSupport.accept(this);
    }

    /**
     * To get the name attribute of the form.
     * Names the element so that it may be referred to from style sheets or scripts.
     *
     * @return the name of the "input" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-INPUT">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the acceptcharset attribute of the form.
     * Accept-charset can be used to specify which character sets should be accepted. This is a comma-separated list.
     *
     * @return the accept-charset of the form
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accept-charset">W3C recommendation</a>
     */
    public String acceptCharset() {
        return attributeSupport.acceptCharset(this);
    }

    /**
     * To get the string describing the form
     *
     * @return string describing the form and its action
     */
    public String toString() {
        return super.toString() + ", action:" + action();
    }

}
