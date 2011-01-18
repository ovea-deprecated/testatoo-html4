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
 * This class allows the testing of the properties of two html4 elements :
 * <ul>
 * <li>button element</li>
 * <li>input element, with type in (submit, reset, image, button)</li>
 * </ul>
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-BUTTON"> "button" specification </a>
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-INPUT"> "input" specification </a>
 */

public final class Button extends org.testatoo.core.component.Button implements Coreattrs, I18n {

    private HtmlEvaluator evaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "button" or "input" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "button" element
     */
    public Button(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
    }

    /**
     * To get the type attribute of the "button" element.
     * For a "button" element, the type can be button, submit or reset.
     * For a "input" element, the type can be button, submit, reset or image.
     *
     * @return the type of the button
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-type-BUTTON">W3C recommendation (button)</a>
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-type-INPUT">W3C recommendation (input)</a>
     */
    public InputType type() {
        return InputType.valueOf(evaluator.attribute(id(), Attribute.type));
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
     * To get the name attribute of the "button" or "input" element.
     * Names the element so that it may be referred to from style sheets or scripts.
     *
     * @return the name of the button
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-BUTTON">W3C recommendation (button)</a>
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-INPUT">W3C recommendation (input)</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the value attribute of the "button" or "input" element.
     * Value is the text written on the button.
     *
     * @return the value of the button
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-value-BUTTON">W3C recommendation (button)</a>
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-value-INPUT">W3C recommendation (input)</a>
     */
    public String value() {
        return attributeSupport.value(this);
    }

    /**
     * To get the alt attribute of the "input" element when its type is "image".
     * Alt can be used when type is set to image to specify the alternative text of the image, for user agents that cannot display images.
     *
     * @return the alt of the button
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-alt">W3C recommendation</a>
     */
    public String alt() {
        return attributeSupport.alt(this);
    }

    /**
     * To get the tabindex attribute of the "button" or "input" element.
     * Tabindex can be used to specify where the element appears in the tab order of the page.
     *
     * @return the tabindex of the button
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }

    /**
     * To get the accesskey attribute of the "button" or "input" element.
     * Accesskey can be used to associate a particular keyboard shortcut to the element.
     *
     * @return the accesskey of the button
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }

}
