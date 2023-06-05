// Generated from /Users/charles/Documents/projects/Espresso/src/main/resources/Espresso.g4 by ANTLR 4.12.0
package org.csfundamental.syntax;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EspressoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "';'", "'['", "']'", "','", "'('", "')'", "'.'", 
			"'='", "':'", "'++'", "'--'", "'+'", "'-'", "'~'", "'!'", "'*'", "'/'", 
			"'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", 
			"'&&'", "'||'", "'?'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", 
			"'^='", "'>>='", "'>>>='", "'<<='", "'%='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public EspressoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Espresso.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000+\u00c4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0000"+
		"\u0000+\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\""+
		"E#G$I%K&M\'O(Q)S*U+\u0001\u0000\u0000\u00c3\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?"+
		"\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000"+
		"\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000"+
		"\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M"+
		"\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000"+
		"\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000"+
		"\u0001W\u0001\u0000\u0000\u0000\u0003Y\u0001\u0000\u0000\u0000\u0005["+
		"\u0001\u0000\u0000\u0000\u0007]\u0001\u0000\u0000\u0000\t_\u0001\u0000"+
		"\u0000\u0000\u000ba\u0001\u0000\u0000\u0000\rc\u0001\u0000\u0000\u0000"+
		"\u000fe\u0001\u0000\u0000\u0000\u0011g\u0001\u0000\u0000\u0000\u0013i"+
		"\u0001\u0000\u0000\u0000\u0015k\u0001\u0000\u0000\u0000\u0017m\u0001\u0000"+
		"\u0000\u0000\u0019p\u0001\u0000\u0000\u0000\u001bs\u0001\u0000\u0000\u0000"+
		"\u001du\u0001\u0000\u0000\u0000\u001fw\u0001\u0000\u0000\u0000!y\u0001"+
		"\u0000\u0000\u0000#{\u0001\u0000\u0000\u0000%}\u0001\u0000\u0000\u0000"+
		"\'\u007f\u0001\u0000\u0000\u0000)\u0081\u0001\u0000\u0000\u0000+\u0083"+
		"\u0001\u0000\u0000\u0000-\u0085\u0001\u0000\u0000\u0000/\u0088\u0001\u0000"+
		"\u0000\u00001\u008b\u0001\u0000\u0000\u00003\u008e\u0001\u0000\u0000\u0000"+
		"5\u0091\u0001\u0000\u0000\u00007\u0093\u0001\u0000\u0000\u00009\u0095"+
		"\u0001\u0000\u0000\u0000;\u0097\u0001\u0000\u0000\u0000=\u009a\u0001\u0000"+
		"\u0000\u0000?\u009d\u0001\u0000\u0000\u0000A\u009f\u0001\u0000\u0000\u0000"+
		"C\u00a2\u0001\u0000\u0000\u0000E\u00a5\u0001\u0000\u0000\u0000G\u00a8"+
		"\u0001\u0000\u0000\u0000I\u00ab\u0001\u0000\u0000\u0000K\u00ae\u0001\u0000"+
		"\u0000\u0000M\u00b1\u0001\u0000\u0000\u0000O\u00b4\u0001\u0000\u0000\u0000"+
		"Q\u00b8\u0001\u0000\u0000\u0000S\u00bd\u0001\u0000\u0000\u0000U\u00c1"+
		"\u0001\u0000\u0000\u0000WX\u0005{\u0000\u0000X\u0002\u0001\u0000\u0000"+
		"\u0000YZ\u0005}\u0000\u0000Z\u0004\u0001\u0000\u0000\u0000[\\\u0005;\u0000"+
		"\u0000\\\u0006\u0001\u0000\u0000\u0000]^\u0005[\u0000\u0000^\b\u0001\u0000"+
		"\u0000\u0000_`\u0005]\u0000\u0000`\n\u0001\u0000\u0000\u0000ab\u0005,"+
		"\u0000\u0000b\f\u0001\u0000\u0000\u0000cd\u0005(\u0000\u0000d\u000e\u0001"+
		"\u0000\u0000\u0000ef\u0005)\u0000\u0000f\u0010\u0001\u0000\u0000\u0000"+
		"gh\u0005.\u0000\u0000h\u0012\u0001\u0000\u0000\u0000ij\u0005=\u0000\u0000"+
		"j\u0014\u0001\u0000\u0000\u0000kl\u0005:\u0000\u0000l\u0016\u0001\u0000"+
		"\u0000\u0000mn\u0005+\u0000\u0000no\u0005+\u0000\u0000o\u0018\u0001\u0000"+
		"\u0000\u0000pq\u0005-\u0000\u0000qr\u0005-\u0000\u0000r\u001a\u0001\u0000"+
		"\u0000\u0000st\u0005+\u0000\u0000t\u001c\u0001\u0000\u0000\u0000uv\u0005"+
		"-\u0000\u0000v\u001e\u0001\u0000\u0000\u0000wx\u0005~\u0000\u0000x \u0001"+
		"\u0000\u0000\u0000yz\u0005!\u0000\u0000z\"\u0001\u0000\u0000\u0000{|\u0005"+
		"*\u0000\u0000|$\u0001\u0000\u0000\u0000}~\u0005/\u0000\u0000~&\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005%\u0000\u0000\u0080(\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005<\u0000\u0000\u0082*\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005>\u0000\u0000\u0084,\u0001\u0000\u0000\u0000\u0085\u0086\u0005<"+
		"\u0000\u0000\u0086\u0087\u0005=\u0000\u0000\u0087.\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005>\u0000\u0000\u0089\u008a\u0005=\u0000\u0000\u008a0"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005=\u0000\u0000\u008c\u008d\u0005"+
		"=\u0000\u0000\u008d2\u0001\u0000\u0000\u0000\u008e\u008f\u0005!\u0000"+
		"\u0000\u008f\u0090\u0005=\u0000\u0000\u00904\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005&\u0000\u0000\u00926\u0001\u0000\u0000\u0000\u0093\u0094\u0005"+
		"^\u0000\u0000\u00948\u0001\u0000\u0000\u0000\u0095\u0096\u0005|\u0000"+
		"\u0000\u0096:\u0001\u0000\u0000\u0000\u0097\u0098\u0005&\u0000\u0000\u0098"+
		"\u0099\u0005&\u0000\u0000\u0099<\u0001\u0000\u0000\u0000\u009a\u009b\u0005"+
		"|\u0000\u0000\u009b\u009c\u0005|\u0000\u0000\u009c>\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005?\u0000\u0000\u009e@\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0005+\u0000\u0000\u00a0\u00a1\u0005=\u0000\u0000\u00a1B\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0005-\u0000\u0000\u00a3\u00a4\u0005=\u0000"+
		"\u0000\u00a4D\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005*\u0000\u0000\u00a6"+
		"\u00a7\u0005=\u0000\u0000\u00a7F\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005"+
		"/\u0000\u0000\u00a9\u00aa\u0005=\u0000\u0000\u00aaH\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005&\u0000\u0000\u00ac\u00ad\u0005=\u0000\u0000\u00ad"+
		"J\u0001\u0000\u0000\u0000\u00ae\u00af\u0005|\u0000\u0000\u00af\u00b0\u0005"+
		"=\u0000\u0000\u00b0L\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005^\u0000"+
		"\u0000\u00b2\u00b3\u0005=\u0000\u0000\u00b3N\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0005>\u0000\u0000\u00b5\u00b6\u0005>\u0000\u0000\u00b6\u00b7\u0005"+
		"=\u0000\u0000\u00b7P\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005>\u0000"+
		"\u0000\u00b9\u00ba\u0005>\u0000\u0000\u00ba\u00bb\u0005>\u0000\u0000\u00bb"+
		"\u00bc\u0005=\u0000\u0000\u00bcR\u0001\u0000\u0000\u0000\u00bd\u00be\u0005"+
		"<\u0000\u0000\u00be\u00bf\u0005<\u0000\u0000\u00bf\u00c0\u0005=\u0000"+
		"\u0000\u00c0T\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005%\u0000\u0000\u00c2"+
		"\u00c3\u0005=\u0000\u0000\u00c3V\u0001\u0000\u0000\u0000\u0001\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}