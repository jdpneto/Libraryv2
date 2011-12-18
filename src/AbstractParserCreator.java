/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jlnabais
 */
public abstract class AbstractParserCreator {
    //the factory method
    public abstract Parser createParser();

    //the operations that are implemented for all ParserCreators
    public Parser getParser()
    {
        //depending on the subclass, we'll get a particular parser.
        Parser parser = createParser();

        //could do other operations on the parser here

        return parser;
    }

}
