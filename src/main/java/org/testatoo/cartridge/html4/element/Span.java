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
import org.testatoo.core.nature.TextSupport;

import static org.testatoo.cartridge.html4.element.HtmlElementType.Span;

/**
 * This class allows the testing of the "span" element properties for html4.
 * Span is a division/grouping element that defines a block of HTML ; commonly used to apply CSS to a chunk of a page.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/global.html#edef-SPAN"> "span" specification </a>
 */

public final class Span extends Component implements Coreattrs, I18n, TextSupport {

    private HtmlEvaluator evaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the acronym element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the acronym element
     * @throws org.testatoo.core.ComponentException
     *          if the given id does not correspond to a "acronym" element
     */
    public Span(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Span) {
            throw new ComponentException("The component with id=" + id + " is not a " + Span + " but a " + evaluator.htmlElementType(id));
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

    @Override
    public String text() {
        return evaluator.content(this);
    }

    /**
     * @see Component
     */
    @Override
    public String toString() {
        return super.toString() + ", title:" + title();
    }

}
