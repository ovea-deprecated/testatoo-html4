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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Abbr;
import static org.testatoo.cartridge.html4.element.HtmlElementType.Undefined;

/**
 * This class allows the testing of the "abbr" properties of a structured text for html4.
 * Abbr defines an element in a structured text that is a shortened word or phrase.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/text.html#edef-ABBR"> abbr specification </a>
 */

public final class Abbr extends Phrase implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the abbr element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the abbr element
     * @throws ComponentException if the given id does not correspond to a "abbr" element
     */
    public Abbr(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Abbr && evaluator.htmlElementType(id) != Undefined) {
            throw new ComponentException("The component with id=" + id + " is not a " + Abbr + " but a " + evaluator.htmlElementType(id));
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
}

