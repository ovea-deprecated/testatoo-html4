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

/**
 * This class is the implementation of the attributes presented in i18n interface.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#i18n">%i18n specifications </a>
 */
public final class I18nAttributeSupport {

    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use
     *
     * @param evaluator a UI Test engine specific html evaluator
     */
    I18nAttributeSupport(HtmlEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * To get the language attribute of the html element
     *
     * @param component the html element
     * @return the language attribute of the html element
     * @see <a href="http://www.w3.org/TR/html401/struct/dirlang.html#adef-lang"> lang specification </a>
     */
    String language(Component component) {
        return evaluator.attribute(component.id(), Attribute.lang);
    }

    /**
     * To get the direction attribute of the html element ; launches an exception if direction is not in (rtl, ltr).
     *
     * @param component the html element*
     * @return the direction attribute of the html element
     * @see <a href="http://www.w3.org/TR/html401/struct/dirlang.html#adef-dir"> dir specification </a>
     */
    Direction direction(Component component) {
        String direction = evaluator.attribute(component.id(), Attribute.dir).trim();

        if (direction.equals("") || direction.equalsIgnoreCase("ltr"))
            return Direction.lefttoright;
        if (direction.equalsIgnoreCase("rtl"))
            return Direction.righttoleft;
        throw new ComponentException("Invalid direction value");
    }

}
