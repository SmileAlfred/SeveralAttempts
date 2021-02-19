package rail_test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;

public class Hanzi2Pinyin {

    public static String str = "弟子规，圣人训。\n" +
            "首孝悌，次谨信。\n" +
            "泛爱众，而亲仁。\n" +
            "有余力，则学文。\n" +
            "父母呼，应勿缓。\n" +
            "父母命，行勿懒。\n" +
            "父母教，须敬听。\n" +
            "父母责，须顺承。\n" +
            "冬则温，夏则凊。\n" +
            "晨则省，昏则定。\n" +
            "出必告，反必面。\n" +
            "居有常，业无变。\n" +
            "事虽小，勿擅为。\n" +
            "苟擅为，子道亏。\n" +
            "物虽小，勿私藏。\n" +
            "苟私藏，亲心伤。\n" +
            "亲所好，力为具。\n" +
            "亲所恶，谨为去。\n" +
            "身有伤，贻亲忧。\n" +
            "德有伤，贻亲羞。\n" +
            "亲爱我，孝何难。\n" +
            "亲憎我，孝方贤。\n" +
            "亲有过，谏使更。\n" +
            "怡吾色，柔吾声。\n" +
            "谏不入，悦复谏。\n" +
            "号泣随，挞无怨。\n" +
            "亲有疾，药先尝。\n" +
            "昼夜侍，不离床。\n" +
            "丧三年，常悲咽。\n" +
            "居处变，酒肉绝。\n" +
            "丧尽礼，祭尽诚。\n" +
            "事死者，如事生。\n" +
            "兄道友，弟道恭。\n" +
            "兄弟睦，孝在中。\n" +
            "财物轻，怨何生。\n" +
            "言语忍，忿自泯。\n" +
            "或饮食，或坐走。\n" +
            "长者先，幼者后。\n" +
            "长呼人，即代叫。\n" +
            "人不在，己即到。\n" +
            "称尊长，勿呼名。\n" +
            "对尊长，勿见能。\n" +
            "路遇长，疾趋揖。\n" +
            "长无言，退恭立。\n" +
            "骑下马，乘下车。\n" +
            "过犹待，百步余。\n" +
            "长者立，幼勿坐。\n" +
            "长者坐，命乃坐。\n" +
            "尊长前，声要低。\n" +
            "低不闻，却非宜。\n" +
            "进必趋，退必迟。\n" +
            "问起对，视勿移。\n" +
            "事诸父，如事父。\n" +
            "事诸兄，如事兄。\n" +
            "朝起早，夜眠迟。\n" +
            "老易至，惜此时。\n" +
            "晨必盥，兼漱口。\n" +
            "便溺回，辄净手。\n" +
            "冠必正，纽必结。\n" +
            "袜与履，俱紧切。\n" +
            "置冠服，有定位。\n" +
            "勿乱顿，致污秽。\n" +
            "衣贵洁，不贵华。\n" +
            "上循分，下称家。\n" +
            "对饮食，勿拣择。\n" +
            "食适可，勿过则。\n" +
            "年方少，勿饮酒。\n" +
            "饮酒醉，最为丑。\n" +
            "步从容，立端正。\n" +
            "揖深圆，拜恭敬。\n" +
            "勿践阈，勿跛倚。\n" +
            "勿箕踞，勿摇髀。\n" +
            "缓揭帘，勿有声。\n" +
            "宽转弯，勿触棱。\n" +
            "执虚器，如执盈。\n" +
            "入虚室，如有人。\n" +
            "事勿忙，忙多错。\n" +
            "勿畏难，勿轻略。\n" +
            "斗闹场，绝勿近。\n" +
            "邪僻事，绝勿问。\n" +
            "将入门，问孰存。\n" +
            "将上堂，声必扬。\n" +
            "人问谁，对以名。\n" +
            "吾与我，不分明。\n" +
            "用人物，须明求。\n" +
            "倘不问，即为偷。\n" +
            "借人物，及时还。\n" +
            "后有急，借不难。\n" +
            "凡出言，信为先。\n" +
            "诈与妄，奚可焉。\n" +
            "话说多，不如少。\n" +
            "惟其是，勿佞巧。\n" +
            "奸巧语，秽污词。\n" +
            "市井气，切戒之。\n" +
            "见未真，勿轻言。\n" +
            "知未的，勿轻传。\n" +
            "事非宜，勿轻诺。\n" +
            "苟轻诺，进退错。\n" +
            "凡道字，重且舒。\n" +
            "勿急疾，勿模糊。\n" +
            "彼说长，此说短。\n" +
            "不关己，莫闲管。\n" +
            "见人善，即思齐。\n" +
            "纵去远，以渐跻。\n" +
            "见人恶，即内省。\n" +
            "有则改，无加警。\n" +
            "唯德学，唯才艺。\n" +
            "不如人，当自砺。\n" +
            "若衣服，若饮食。\n" +
            "不如人，勿生戚。\n" +
            "闻过怒，闻誉乐。\n" +
            "损友来，益友却。\n" +
            "闻誉恐，闻过欣。\n" +
            "直谅士，渐相亲。\n" +
            "无心非，名为错。\n" +
            "有心非，名为恶。\n" +
            "过能改，归于无。\n" +
            "倘掩饰，增一辜。\n" +
            "凡是人，皆须爱。\n" +
            "天同覆，地同载。\n" +
            "行高者，名自高。\n" +
            "人所重，非貌高。\n" +
            "才大者，望自大。\n" +
            "人所服，非言大。\n" +
            "己有能，勿自私。\n" +
            "人所能，勿轻訾。\n" +
            "勿谄富，勿骄贫。\n" +
            "勿厌故，勿喜新。\n" +
            "人不闲，勿事搅。\n" +
            "人不安，勿话扰。\n" +
            "人有短，切莫揭。\n" +
            "人有私，切莫说。\n" +
            "道人善，即是善。\n" +
            "人知之，愈思勉。\n" +
            "扬人恶，即是恶。\n" +
            "疾之甚，祸且作。\n" +
            "善相劝，德皆建。\n" +
            "过不规，道两亏。\n" +
            "凡取与，贵分晓。\n" +
            "与宜多，取宜少。\n" +
            "将加人，先问己。\n" +
            "己不欲，即速已。\n" +
            "恩欲报，怨欲忘。\n" +
            "抱怨短，报恩长。\n" +
            "待婢仆，身贵端。\n" +
            "虽贵端，慈而宽。\n" +
            "势服人，心不然。\n" +
            "理服人，方无言。\n" +
            "同是人，类不齐。\n" +
            "流俗众，仁者希。\n" +
            "果仁者，人多畏。\n" +
            "言不讳，色不媚。\n" +
            "能亲仁，无限好。\n" +
            "德日进，过日少。\n" +
            "不亲仁，无限害。\n" +
            "小人进，百事坏。\n" +
            "不力行，但学文。\n" +
            "长浮华，成何人。\n" +
            "但力行，不学文。\n" +
            "任己见，昧理真。\n" +
            "读书法，有三到。\n" +
            "心眼口，信皆要。\n" +
            "方读此，勿慕彼。\n" +
            "此未终，彼勿起。\n" +
            "宽为限，紧用功。\n" +
            "工夫到，滞塞通。\n" +
            "心有疑，随札记。\n" +
            "就人问，求确义。\n" +
            "房室清，墙壁净。\n" +
            "几案洁，笔砚正。\n" +
            "墨磨偏，心不端。\n" +
            "字不敬，心先病。\n" +
            "列典籍，有定处。\n" +
            "读看毕，还原处。\n" +
            "虽有急，卷束齐。\n" +
            "有缺坏，就补之。\n" +
            "非圣书，屏勿视。\n" +
            "蔽聪明，坏心志。\n" +
            "勿自暴，勿自弃。\n" +
            "圣与贤，可驯致。\n" +
            "黎明即起，洒扫庭除，要内外整洁。\n" +
            "既昏便息，关锁门户，必亲自检点。\n" +
            "一粥一饭，当思来处不易；半丝半缕，恒念物力维艰。\n" +
            "宜未雨而绸缪，毋临渴而掘井。\n" +
            "自奉必须俭约，宴客切勿流连。\n" +
            "器具质而洁，瓦缶胜金玉；饭食约而精，园蔬愈珍馐。\n" +
            "勿营华屋，勿谋良田。\n" +
            "三姑六婆，实淫盗之媒；婢美妾娇，非闺房之福。\n" +
            "童仆勿用俊美，妻妾切忌艳妆。\n" +
            "祖宗虽远，祭祀不可不诚；子孙虽愚，经书不可不读。\n" +
            "居身务期质朴，教子要有义方。\n" +
            "莫贪意外之财，莫饮过量之酒。\n" +
            "与肩挑贸易，毋占便宜；见穷苦亲邻，须加温恤。\n" +
            "刻薄成家，理无久享；伦常乖舛，立见消亡。\n" +
            "兄弟叔侄，须分多润寡；长幼内外，宜法肃辞严。\n" +
            "听妇言，乖骨肉，岂是丈夫；重资财，薄父母，不成人子。\n" +
            "嫁女择佳婿，毋索重聘；娶媳求淑女，勿计厚奁。\n" +
            "见富贵而生谄容者，最可耻；遇贫穷而作骄态者，贱莫甚。\n" +
            "居家戒争讼，讼则终凶；处世戒多言，言多必失。\n" +
            "勿恃势力而凌逼孤寡；毋贪口腹而恣杀性禽。\n" +
            "乖僻自是，悔误必多；颓惰自甘，家道难成。\n" +
            "狎昵恶少，久必受其累；屈志老成，急则可相依。\n" +
            "轻听发言，安知非人之谮诉，当忍耐三思；\n" +
            "因事相争，焉知非我之不是，须平心再想。\n" +
            "施惠无念，受恩莫忘。\n" +
            "凡事当留余地，得意不宜再往。\n" +
            "人有喜庆，不可生妨忌心；人有祸患，不可生喜幸心。\n" +
            "善欲人见，不是真善，恶恐人知，便是大恶。\n" +
            "见色而起淫心，报在妻女；匿怨而用暗箭，祸延子孙。\n" +
            "家门和顺，虽饔飧不济，亦有余欢；\n" +
            "国课早完，囊橐无余，自得其乐。\n" +
            "读书志在圣贤，非徒科第；为官心存君国，岂计身家。\n" +
            "守分安命，顺时听天。为人若此，庶乎近焉。";

    public static String getPingYin(String src) {
        char[] inputChar = null;
        inputChar = src.toCharArray();
        int inputCharLength = inputChar.length;
        String[] piword = new String[inputCharLength];
        HanyuPinyinOutputFormat hPinyinOutputFormat = new HanyuPinyinOutputFormat();
        //大小写
        hPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //带拼音状态(toneType和charType必须成对使用，否则会异常)
//        hPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
//        hPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        hPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        String piStr = "";
        try {
            for (int i = 0; i < inputCharLength; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(inputChar[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    piword = PinyinHelper.toHanyuPinyinStringArray(inputChar[i], hPinyinOutputFormat);
                    piStr += piword[0];
                } else
                    piStr += java.lang.Character.toString(inputChar[i]);
            }
            // System.out.println(t4);
            return piStr;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return piStr;
    }

    // 返回中文的首字母
    public static String getPinYinHeadChar(String str) {

        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    // 将字符串转移为ASCII码
    public static String getCnASCII(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bGBK = cnStr.getBytes();
        for (int i = 0; i < bGBK.length; i++) {
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
        }
        return strBuf.toString();
    }

    public static void main(String[] args) {
        //System.out.println(getPingYin("生活很简单，我是江小白"));
        //System.out.println(getPinYinHeadChar("生活很简单，我是江小白"));
        //System.out.println(getCnASCII("生活很简单，我是江小白"));


        String[] strs = str.split("\n");
        String des = "";
        for (int i = 0; i < strs.length; i++) {
            String index = strs[i].substring(0, 3);
            //des += getPingYin(index) + " " + 1 + " " + strs[i]+"\r\n";
            des += strs[i]+"\r\n";

        }
        System.out.println(des);

    }
}
