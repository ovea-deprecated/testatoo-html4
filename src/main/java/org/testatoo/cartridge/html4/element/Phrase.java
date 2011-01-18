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
import org.testatoo.core.component.Component;
import org.testatoo.core.nature.TextSupport;

/**
 * This abstract class is the base class for phrase elements of a structured text in html4.
 * Phrase elements are : EM, STRONG, DFN, CODE, SAMP, KBD, VAR, CITE, ABBR, and ACRONYM
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/text.html#edef-EM"> phrase elements specification </a>
 */

public abstract class Phrase extends Component implements TextSupport {

    HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the phrase element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the phrase element
     */
    public Phrase(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;
    }

    /**
     * To get the content of the phrase element.
     *
     * @return the text corresponding to the phrase element
     */
    public String text() {
        return evaluator.content(this);
    }


    /**
     * To get the string describing the phrase element.
     *
     * @return string describing the phrase element
     */
    public String toString() {
        return super.toString() + ", text:" + text();
    }
}
