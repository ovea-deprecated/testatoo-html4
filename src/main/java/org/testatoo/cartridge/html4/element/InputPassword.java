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

/**
 * This class allows the testing of the "input" element (with "password" type)  properties,  for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-INPUT"> "input" specification </a>
 */

public final class InputPassword extends org.testatoo.core.component.PasswordField implements Coreattrs, I18n {

    private HtmlEvaluator evaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "input" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "input" element
     */
    public InputPassword(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
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
     * To get the type attribute of the "input" element, that is "password".
     *
     * @return the password type of the "input" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-type-INPUT">W3C recommendation</a>
     */
    public InputType type() {
        return InputType.password;
    }

    /**
     * To get the readonly attribute of the password input.
     *
     * @return true if the password cannot be modified
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-readonly">W3C recommendation</a>
     */
    public boolean isReadOnly() {
        return evaluator.isReadOnly(this);
    }

    /**
     * To get the name attribute of the password input.
     * Name can be used to associate a name to the password input so that it can be processed by a form-handling script.
     *
     * @return the name of the password input
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-INPUT">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the alt attribute of the password input.
     * Alt is used to set the alternative text of the image, but it exists in W3C specification for all types of input.
     *
     * @return the alt of the password input
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-alt">W3C recommendation</a>
     */
    public String alt() {
        return attributeSupport.alt(this);
    }

    /**
     * To get the tabindex attribute of the password input.
     * Tabindex can be used to specify where the password input is in the tab order of the page.
     *
     * @return the tabindex of the password input
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }

    /**
     * To get the accesskey attribute of the password input.
     * Accesskey can be used to associate a particular keyboard shortcut to the password input.
     *
     * @return the accesskey of the password input
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }

    /**
     * To get the size attribute of the password input.
     * In this case, size is a number of characters.
     *
     * @return the size of the password input
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-size-INPUT">W3C recommendation</a>
     */
    public int size() {
        return attributeSupport.size(this);
    }

}
