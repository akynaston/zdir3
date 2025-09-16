/*
 * IdMUnit - Automated Testing Framework for Identity Management Solutions
 * Copyright (c) 2005-2016 TriVir, LLC
 *
 * This program is licensed under the terms of the GNU General Public License
 * Version 2 (the "License") as published by the Free Software Foundation, and
 * the TriVir Licensing Policies (the "License Policies").  A copy of the License
 * and the Policies were distributed with this program.
 *
 * The License is available at:
 * http://www.gnu.org/copyleft/gpl.html
 *
 * The Policies are available at:
 * http://www.idmunit.org/licensing/index.html
 *
 * Unless required by applicable law or agreed to in writing, this program is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.  See the License and the Policies
 * for specific language governing the use of this program.
 *
 * www.TriVir.com
 * TriVir LLC
 * 13890 Braddock Road
 * Suite 310
 * Centreville, Virginia 20121
 *
 */

package org.idmunit.injector;

import org.idmunit.ConfigLoader;
import org.idmunit.IdMUnitException;
import org.idmunit.injector.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Create a random digit number that persists for the entire test run.
 *  This allows the same value to be used across multiple connector definitions.
 *
 * @author Aaron Kynaston
 * @see Injection
 * @see ConfigLoader
 *
 * Example:
 * {@code
 * <data-injection> <!-- for IDtoFMS tests: -->
 *     <type>org.idmunit.injector.RandomDigitsPerRunInjection</type>
 *     <key>%CNPOSTFIX%</key>
 *     <digits>4</digits>
 *  </data-injection>
 *  }
 */

public class RandomDigitsPerRunInjection implements Injection {
    private static Logger log = LoggerFactory.getLogger(RandomDigitsPerRunInjection.class);

    private List<String> opsList;
    private Calendar cal;
    private String timezone = null;

    public static void main(String[] args) throws Exception {
        RandomDigitsPerRunInjection rand = new RandomDigitsPerRunInjection();
        // Should all be the same value; so we can preserve the same value through each sheet.
        //  We could technically have a new value per sheet; but this is unnecessary.
        System.out.println("next is: " + rand.getDataInjection(null));
        System.out.println("next is: " + rand.getDataInjection(null));
        System.out.println("next is: " + rand.getDataInjection(null));
        System.out.println("next is: " + rand.getDataInjection(null));
        System.out.println("next is: " + rand.getDataInjection(null));
    }

    // Static, to ensure we only use one set of random digits per each test run across all sheets.
    private static String randomdigits = null;

    public void mutate(String mutation)  throws IdMUnitException {
        throw new IdMUnitException("FATAL: the RandomDigitsPerRunInjection does not support mutations!");
    }

    public String getDataInjection(String formatter) throws IdMUnitException {
        log.trace(" . . .Generating static random number " + formatter);

        if (randomdigits != null) {
            return randomdigits;
        }

        randomdigits = "";
        Random random = new Random();
        for (int ctr = 0; ctr < 4; ctr++) {
            int randomDigit = random.nextInt(10);
            randomdigits = randomdigits + randomDigit;
        }
        //String returnVal = String.format("%010s", randomdigits);
        return randomdigits;
    }
}
