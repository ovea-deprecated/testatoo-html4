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
import org.testatoo.core.component.FileDialog;

import static org.testatoo.cartridge.html4.element.HtmlElementType.File;

/**
 * This class allows the testing of the "input" element (with "file" type)  properties,  for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-INPUT"> "input" specification </a>
 */

public class File extends FileDialog implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "input" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "input" element
     * @throws ComponentException if the given id does not correspond to a "input" element with type="file"
     */
    public File(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);

        if (evaluator.htmlElementType(id) != File) {
            throw new ComponentException("The component with id=" + id + " is not a " + File + " but a " + evaluator.htmlElementType(id));
        }
    }

    /**
     * @see I18nAttributeSupport
     */
    public Direction direction() {
        return i18nAttributeSupport.direction(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public String language() {
        return i18nAttributeSupport.language(this);
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
     * To get the type attribute of the "input" element, that is "file".
     *
     * @return the file type of the "input" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-type-INPUT">W3C recommendation</a>
     */
    public InputType type() {
        return InputType.file;
    }

    /**
     * To get the name attribute of the file.
     * Name can be used to associate a name to the "input" element so that it can be processed by a form-handling script.
     *
     * @return the name of the file
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-INPUT">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the alt attribute of the file.
     * Alt is used to set the alternative text of the image, but it exists in W3C specification for all types of input.
     *
     * @return the alt of the file
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-alt">W3C recommendation</a>
     */
    public String alt() {
        return attributeSupport.alt(this);
    }

    /**
     * To get the value attribute of the file.
     * Value in this case is the complete path towards the file.
     *
     * @return the complete path of the file
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-value-INPUT">W3C recommendation</a>
     */
    public String value() {
        // Return empty string for security constraint
        return "";
//        return this.selectedFilePath();
    }

    @Override
    public String selectedFilePath() {
        // Return empty string for security constraint
        return "";
//        return this.selectedFilePath();
    }

    /**
     * To get the tabindex attribute of the file.
     * Tabindex can be used to specify where the file appears in the tab order of the page.
     *
     * @return the tabindex of the file
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }

    /**
     * To get the accesskey attribute of the file.
     * Accesskey can be used to associate a particular keyboard shortcut to the file.
     *
     * @return the accesskey of the file
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }

    /**
     * To get the accept attribute of the file.
     * Accept is used to specify which file-types should be accepted. This is a comma-separated list of MIME types.
     *
     * @return the accept of the file
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accept">W3C recommendation</a>
     */
    public String accept() {
        return attributeSupport.accept(this);
    }
}
