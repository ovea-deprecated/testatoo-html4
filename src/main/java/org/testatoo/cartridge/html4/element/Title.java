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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Title;

/**
 * This class allows the testing of the "H1, H2, H3, H4, H5, H6" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html4/struct/global.html#edef-H1"> "h1... h6" specification </a>
 */

public class Title extends Component implements Coreattrs, I18n, TextSupport {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private HtmlEvaluator evaluator;

    public enum Level {
        H1, H2, H3, H4, H5, H6
    }

    /**
     * Class constructor specifying the evaluator to use and the id of the H1... H6 element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the H1...H6 element
     * @throws ComponentException if the given id does not correspond to a "th" element
     */
    public Title(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Title) {
            throw new ComponentException("The component with id=" + id + " is not a " + Title + " but a " + evaluator.htmlElementType(id));
        }
    }

    public Level level() {
        return Level.valueOf(evaluator.nodename(this));
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
        return evaluator.text(this);
    }

    @Override
    public String toString() {
        return super.toString() + ", text:" + text();
    }
}
