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

import static org.testatoo.cartridge.html4.element.HtmlElementType.P;

/**
 * This class allows the testing of the "p" properties of a structured text for html4.
 * P element represents a paragraph
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/text.html#edef-P"> P specification </a>
 */

public final class P extends Phrase implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "a" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "p" element
     * @throws org.testatoo.core.ComponentException
     *          if the given id does not correspond to a "a" element
     */
    public P(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != P) {
            throw new ComponentException("The component with id=" + id + " is not a " + P + " but a " + evaluator.htmlElementType(id));
        }
    }

    @Override
    public String classname() {
        return coreAttributeSupport.classname(this);
    }

    @Override
    public String style() {
        return coreAttributeSupport.style(this);
    }

    @Override
    public String title() {
        return coreAttributeSupport.title(this);
    }

    @Override
    public String language() {
        return i18nAttributeSupport.language(this);
    }

    @Override
    public Direction direction() {
        return i18nAttributeSupport.direction(this);
    }
}
