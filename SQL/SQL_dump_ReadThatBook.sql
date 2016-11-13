-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: read_that_book
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `BookID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `Author` varchar(255) DEFAULT NULL,
  `ISBN10` varchar(13) DEFAULT NULL,
  `ISBN13` varchar(17) DEFAULT NULL,
  `Genre` varchar(255) DEFAULT NULL,
  `Edition` varchar(10) DEFAULT NULL,
  `Publisher` varchar(50) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`BookID`),
  UNIQUE KEY `title` (`title`,`Author`,`ISBN10`,`ISBN13`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Pride & Predujice','Jane Austin','1234567890','9637538527411','Drama','2','McGrawT','ok'),(3,'Harry Potter','J K Rowling','2346890','1142','Fantasy','1','FWS','ok'),(17,'Harry Potter and the Cursed Child â Parts One and Two (Special Rehearsal Edition)','J.K. Rowling, John Tiffany, Jack Thorne','1781107041','9781781107041','Drama','','Pottermore','Based on an original new story by J.K. Rowling, Jack Thorne and John Tiffany, a new play by Jack Thorne, Harry Potter and the Cursed Child is the eighth story in the Harry Potter series and the first official Harry Potter story to be presented on stage. The play received its world premiere in Londonâs West End on 30th July 2016. It was always difficult being Harry Potter and it isnât much easier now that he is an overworked employee of the Ministry of Magic, a husband and father of three school-age children. While Harry grapples with a past that refuses to stay where it belongs, his youngest son Albus must struggle with the weight of a family legacy he never wanted. As past and present fuse ominously, both father and son learn the uncomfortable truth: sometimes, darkness comes from unexpected places.'),(25,'Master of the Game','Sidney Sheldon','000737061X','9780007370610','Fiction','1','HarperCollins UK','One of Sidney Sheldonâs most popular and bestselling titles, published in ebook format for a new generation of fans.');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookimage`
--

DROP TABLE IF EXISTS `bookimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookimage` (
  `IMAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Book_id` int(11) DEFAULT NULL,
  `image` blob,
  `Image_Link` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`IMAGE_ID`),
  UNIQUE KEY `Book_id` (`Book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookimage`
--

LOCK TABLES `bookimage` WRITE;
/*!40000 ALTER TABLE `bookimage` DISABLE KEYS */;
INSERT INTO `bookimage` VALUES (1,1,'󜘿\ᜰJFIF\0\0\0\0\0\0󜛜0C\0	\Z!\Z\"$\"$󜛜0C󀜰\0\ɜ0z\"\0󜄜0\0\0\0\0\0\0\0\0\0\0\0\0	󜄜0A\0\0\0\0!1AQ\"aqQH#2B\Ғі$Ubԁ\ᳶrs񣿜Ŝ0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0󜄜0.\0\0\0\0\0\0\0!1Q\"2AaⰤqєB󜚜0\0\0?\0\̏ѯh͜ﴁTOٸֹļ\ɒʒєe\뗳󜭤gy\5񇸱ж\׆𜜡zp͠DهحU񏜊[Οыb\ٷڢIÖͣu\떒\ݛ\\Ȝٗʈh%ĸەa!½4ѯ=\Ć\Ã󜰭օ\ߛ,uTz\ן\夵=\Ŝ絽͗¼\˘ҹ)Npz\ɜ𷂭ȸڱ$3Qڜ\ÃΎ=Ԑo-ģ_줟\󹤱󚀺Rب򑨟堍Oq:߱ʠ\ٷjќƉ\靜#tر\0\㸜؟O񽽿\0𜃽ԉwϜ⠜䭋߸ʿ֏𜓱󜰼?򫽴ʶ\"p?cǰϲÜɥ+\0q޳\࠲ץ\ط֙HFH󜰜Ľ\Ǉ\ԈWyn\Ѝp\\ܜDĜ'򐻜̱(\×3ߜ"_\񗁚ߜ㷺~\ƭС^dĔl8ѰA]֜ŜٗٺڥĮ֪ؐퟞ򋐣]\幗񫀜М'/򜗆򜜫ޚ݆ܟ\́\ZϜ⚜Զ1\\{\n󜧗Dԍ\Ӝƛ𭮦½8%$Ġǒ\ᝠϜۄܜȰϺkÜ坤\⦜弶\؆򜜣񫱜ϸο֌j{ɧO\مɰoR(dzRЙ򜚜຾߿\0Ώ򡾜ۂܜ̰ɜ×ř\΄J?\鰟\韜怜0x񫽵\ͪۈgM\ٜɜ-ܪo̗̝ϜͣԶ5ל薘\¿򟥤ؑǅ؂߷\0r\0\Zµ.ԸȰޭл҂GtkࠜƹǨ\ɣ򜊴\㝽 }r;򩜗#8{񥴠ٿ\0Yќ飺\ܯTKT򛭌ŮڢiӚɅAϥ𙒇Hc\ꕑݺl̜͘㕿󽾜֜rۭ\ѥQ\ͲJҔp$H\β\"Ȭr˟\\Dyě6ݓZ࠲\坒HΪ9ɜ똜͠Ξ>aν?=Hh𚸜\ל˜壜ݒߨ?\ۊ񲊁Ĉ𹤥Tρ\履дκ񻆏9̑𻸪򜛑\"ʪ񱖜r􈜡~Ȝ鹜鄞̂ǀ\홽-ϜU-ޮx%ٓ\ǤpӆնAϜ󭐠ݯ:Kה2V\ِ\ʫj¯ݪJ񱌜溝z~~עT½񄱥;o\ĕӜ-	dϗʦ*ÿ߁vϵդtݶ\鸸\𧁜塜؇#࠹\"B\ִYם򣸩̍n̥߷ȳMN\ᄒ0Uц2ߺӸ)EGpҺܥdԖ	̩\rR)NМZ̤񌹜ɮ;@u\℄Ă;|uݐMK<\'⊱ӜnʉTҜ鹄Tڑ\ȥ ͣL۳vǜ˼̭𓷶Km%Ȝ겣ЂXay`Uq\꟏hеԌv2\޻*\ҽ׫ߘۘ-մ4B򦥜ͼ5ҡ\둲˂ƗȜ梃\ꎐX<1ߜҮ+3^h(傢\戌𵲜̜0է_1#.8?\Ɍޝ,y\ȽE̛՛vu󮼏ܯN\򇑜Ӣ򙊜ᣜֹ\蝛\՜Ю\-\М㷒ߗ\ܒǜ䗫yٖ\ZМໜÜɜZ^£@[\棂@\긹\ȟoݜ靘Nq\ͦư\׳t϶GISmƮ񵔔˜ӹTқՏI aƏ9񆜼8\۱k̯q\ьջZ\ꞃO\'SJߔrٜ00߼m̟\ꜧԜ띉\ⓙjiXX¸5ӜA#\ϣɕGWP	a򩘫ĜԸޏEh%ࠬ\ƕUEl̴-OŲyԕg\˜ʗ׏5ۛ=Ϡܑ\Ĝ㞱񜏜ۈx`\籥󧔏Md֒לރ	\ܢ\ꕺ\՜ʜ"ډ޳+ǜ\˗鏡AΉ!5ܜċ񞎪\ܽE𱜋,1ԩԊ֜㉊7F\媇_NY\[݉ʜQAUסˣ̯=Ʀʡ\聒ك˅񜈉Ҁ\㍜顯|۽ֵMʥÂݫm\ౘ҆tTts\ҳ̴! \奣Ѡ6щ\'YѮ޳MɆΜZ4B\ZӜ*j\ۋ\얐񭋬i\Ṉ\꿶5ϼ9\䑭)ǫވƊ)]`@ǝ@p~ڜ0\䝜\rEc2וlьڶޡΎ\ձBjgƸ%\ְς\σ*򴑉β\睪׭\붅\㝊𜈪\̰\0\τ𩸒\'\nx+աȰA񠗁\ݿS~z򝇵\Ћ5ؾĆG򶺿~󜰾c񜞜٣\ߩɜ靨𧨜葆˜읦=<$ϛ#ߧ\Zҭǜ̑SG-/=$׺\ȋu֤͆\'e\Ꝭ~l\Â򵐳˹ޙڋѾ񜗃ع\羵֬ކAnE$֜Ϥ˜ʯº\ٜ༓ݺڶ3ɇ2t˺ʜ띩\쿟ppt\仪ƒв֕ƚi\픆\ǼƳ\չR2q\Ԁ=ퟺ𗏴ߧڜ׽y\Жy𵳎@$޺ձ=gV񑍿ؓԳ\Ҽ6\ߩh\쫁O\ŜڠҺsӆx󆒜Ӝrץ\ʪ+cΎٳ-?\ɡҗ\Ԑ٬r1\ɤ\ƺ\ߞ\ڜ䟋фH\'\'ࠝpV\赜龊ѶxѣF۪\Ćڎ޼ߜşfX\ƪ	ѕÂŽޗCJj3HFFpއ\ٳ\ܞ\d#Ξ\ū\΂МㅽC.ˆb?֢܌ΰH𨑩NCFΜZ!\r{ʷrB)88\՜ȜÝ˾󜰜ݜ㝉OrƠ~ϳˬӀw\鞧[f𙳶ݰ\ΰ̙W,)䔖󲰎	\Мԕ5:Ġ\e۴򦉸Ϻ\殏\ۧjX򮫦ǳR5*\ՄdeJw#}S򽶋P8󋺣Sզ\Z4h\Ԝ"cF͐ƍ\Z4B.۩𜭤:\ܔ\Ƙ\̺u󜰽0itܠӳ\֜r\Z4iҐқe+VWCJīK\"?sͦӆݨJ[\杲Lʙ\"ɇ`{qӃɤ\0І^󟯬ߎج;ƶ񴺜̊񆚜ࠋ\؜徰VY˜\玽3ּ͉Mќej\ʍYǚԈʠg˂x\ݏ\ќꚻ𛬜ևݜ̜"e#𒱯W$Α\읫߃ʥзضΜǜҡĉ+iǉM*t̼ep3Կ\0OƼ\Κ˜큉$\α@CͿ8𜇜◜՜߱\̎ܺΠA!XʚELwX\ʧӏ]QoΣӐ3ƴ-МĻN\흙4U)5%ٜҵA;\ǈ2۩ʜп\Ĕ\ǽՑ\ٷ$򜚉ͱB\0󏲱\ϵӣ֜𩙇]Ǽ/ɸď\鑣WǤ4hѢѣFɉל囹N͜ڑߛ:ǜ뽽Ĺ,\흪	\궜М税̜齑֐L4hѫp\؁׵􊶷\nN\0\Z f\ٰwqˎѷTSԜԜ圢ќȲаG\浜❢e\ݜל=Ϝ剠ΰǈ\乾̡=#\޿򜒝ų̬[&\֗בZϜZD󜩜\5FOӞ=7^7󜰇󺉭\Ջlɧo\䒕u\Ü뇳/q򼜫Ȅ\ޡd򾭍՜ڼ\ㄜԜ竍̹͵mܵ,ՒVȩzʫ(İڀ98\М㫂󘵷:˜ǹ2ٹՇ\㝞\雝rX֪y6؜Ď\뜸̏lפp;\ꮗ\ҜӁ6с3\⺰\ᒞҼ\ĆΜZݲaĆ͐ƍ\Z4B\\k)ѐ\ׁzqܐĻĩM>}+ؑ緡\䛺\ࠜ᝜\ꂱ\̼ÜZ񹨱񇜶\띯𜣳\Ւ󳜮ԯ𝰎<𰐃\טݕ\֖̋ס\0󲤱I̎eﯞ՝󁜚\ۜ녱 ҢsƾpM<5񛜭4a*؀[ĘSÄh~Ĝعi\蠈&)՜֯Yض~\͜۲̜❬6ʊܐ@؍>\򗱜箟ুݳξ$7;̠Ǥ񠽰ڜ෾ڻl򋵦ܔ\ԴќԜÒa#΂ɼݜҘ\ᅈ@\ǵթ׽\ߕ\ᾣ\녯ަF\↣CLW\0p>ڨh/(7mѮҴ\Ԝݩc\Ë򥜴׸\ָ֜˓/Z̀ȭV\ߜ'\ל՜ԚeʪiƑЅE\М࠙𳥛ѳ4\Э̜縜뱜杢\ݽϜ᭕AH\ۄϜȈա\࠴񰮺Ȯ4SÖS񜧑\زz\̻УкCFΜZݔ4hѢѣFɏ\ӻ\ЄޔԴrՄ7Ǥ1񯯝ϜĉIcǵݜ0Ҝ׿@J𹦽\ɹ\'񔋜ሜĆ`߱\ɾ\ۻWł\Ѱ?Șג=Ŝל̑ɜ֪ĢZ\䏉\ժ\ќ̉*8${Мͩ\ʸ#ٜ֜'ٷ7\v|𳪫4ԕ~i´Stׁ󆑹\먩ۤ֨҆\n2\窰}x\՞ūڵڜĳ񜬄Ҡ\琳\Ӝʗ\'IǄ\쒜̈zPӇ؁ΨʜҜZ[b9\r4W\ѓ\ϠybRWѣ֝˔ʜ᩾ˆ\ϳO1񞒬񯜃\˵\髜'k|-Q*០d򚌻ȜÉ\靮3-9\"4q\ݱ̃ͳQ݀𴜉p\۴֒\Ϝӓù/\ԏĔ񴲁TѡŜǷo\rg˜Ҫʦjϙ󻪾ڞXǸŒϟ󏭬λ`ǜЩׯ%pʁ\ȭfs\nל廝j(RҊՄհ񴵩 `\ɜn5٤՘yϦ~ɑH\ۡ\Z4񻜭\̬ޜ˄1K,§Œד \r~ݤ~9\҉$чq\εo2ߜ"p3ϫ\䠎ƿ\0\믎ʺ]q𺜣򖼈H񔤏pFќ֜ޜ革Ҝ襹\Ǥ\ҡ^ќýބu@\ܼXߍ\ў\緗SB̜ժɐ¹󹀝0n󜰑j(\겄ԱĄ9`\뤮>𿦵\蝔\Ĝ"h_𻩢Ȝۉ|GÓ񣷴βOb:9l𴜧߽;~z\Ҝ۶Zz\ˑ=,SĻ\磰8Yw\r\Ʌ޽\Οjɺ\ǡv\̜ǘҳg\0׿ǹ󃘜֜Ҝ࿜튬1\Ī%Ԣϝ򖁜䒻𜓜n׃0ɾW\𞩕ƈȡ*ǜ\sųSܖR;vơv\Μƍ󺊙\䬄ɜڭߘ5*՜߭\תcQK:ݣ9>ڝjDɻ3^렢b՟\̀!G~tخ*ɋϧȜࠑ\4V򜮛՜χ՛ş\̘c\󁨜şݲI%;\Ȱ͜Ꝛ͘\˻ҽԻtaݲ֞\⇳M\ђ+:񅹜ӜꊥY\忟R񊻶|򺢶ȏ\\%לѓݖT˜ͷ^]`2̲޸\蝦mӫ\ԯ^\Ƌ˴u˩X̓ȏ%۲𾝁:ȸ[@\̬ݜ蜢Sߴ\峚v̩\\bް΀\ǽל󼵔𺨂\\Б4ڶ\\kj$ǗJ҉}K̌rqМ껒߶}?\ǙͶɢëνR̔ѣ3ř%\ÃЈ\Vӏȷ̎\ϝ߽М֓zֈuSQ<ݑ|@#ť\ᝥW𣓌򍪩hTς)\ࠨڴМࠫ[\ܜ靦Ƈ§ШҩӼÜ运՜nB߂𜧝E!ի,O	ɖjA\؜ל0ˡ8»jYS׷6󥸸ҽތ\Z\ڢIڀ2Ttל鄺Pp?!Ʌ֊fڜԒ0`\՝!~\\竷\ࠜԖ\0ߴ+񠜆\鉧$(Q\출茜ොꌝ體,ɜؠq񩟏\Ե\ՕÌɆRǆl\ϟáә!SſӜǬ˺Ĝ"%ԩ1a֜򨱜ࠋ𶰮\Ҭ\۵^ӊʜT\Ӭݱ\\nÎq𘜚\О ퟭ񏡒ӊ̴Ҵ˔II	#ǜᶘ\θ\\ߜ̰󶃆hh󒥜"u,s?<՝]ܧ򎲎ޜրJ\܉̌󹴗\᱘.{v\欫Ď*jʣ;𠟜₥ؼ·\򈐬̊򜓀\ɬٗ!҂L\ݨ=5߿\0Wr7Xϖ׸*ZҜ亓\ѻ\ÁԆgʜ0+ߜƏ ݾI\⤑\؜ӅظuǯP\Ä,͆񔃿\0\̕.[\0̍Jͅ̯J-ƆԇʹG&0\ࠏ󜰵^Cv\ݖ;ЃބԲЇ׻c±Ʀ𜚷\ߗʴ\ӝ\"ι،ǰ\㪩\0ʷٶ󓬿\0uܸ֎Ա\ߨjΦ\А\る̋\ӹfQݣ\ט򜧒ҳפ󜰲ͺe)~ƜʺԜٷƕ$\ֲ4o՟?\ʁ9#ȯʇ\į\㋶\Z*ħs\䔜ԓݣƴ񷔫\Ý»򵩜bޡʲޱ\Ϝ0?/\ؗԛcڨҹbCuu6\ݭ>ڻԏٳْ\荳Ʀ6؛rӜ侑Zךk͍\ԣe\'A\ê񰘳G֯=ܟ{\ܒ\nٯpЍ3Ƥƶ񽰻\rE<CͶ\\靚*XY[^؇ǀ\㏜ȐJɷ^\豽\࠽ږ\؍JβDī˷\ʜɜƻq\ࠌ\\'F\ݜϞ4󴉞jeʡҜԜӜٵQ\ٿ\0\ĴΝ?gώ-{Ҫ\ḷ\\ӵځ֞4ס\ꦮp[ޱݜ㓱ΩǦc֤ࠒNο\0kj.6\盰\ё҂\ͪʋa	򞅸o\ȎԜʞ\ǓPn𝶳mȪȩΔ͘͜Ȕ¨\蜰򏹜]򌜍ڍ[ʂDHͥ\ش񜕜Ĝ⏌ŦĤϜ靕磤ŀ±纨򏶵@V\ϲ\ǨؤR	\ᣍ+NgJ֜뽜\*欬֦g.򱤜䉴h\ր\0d\橢ViSĜ搜䩲5%Үٰ񵓔#)\0Ҹ\є$䓓\蒚RD\ˆľ\\s\"ѼҜuj֏сۿ\ѮΦ\\񄷤񓸙\­\紅+BOTr^֜딁񸜏|񜁜̜䗪˭,ɋ\׈\ϴ*و\坧\'<{k\䎥ٜݞZkMƲ׸،ҩ©J \ಜn	ҎرŹ\蛶ڂ8\卜앨}ڜ潝󥵜ÜռSJt񄮈񷔒Ow%MŒՈʞ0ge\လ0ɶnߦu\0\ӜʸTf򜣡ڙðƁ󙺫ƚ\ɜƺH΢\չMܷ̻FՕ\յ\擜,񳞹\Ȝܓ-ͺ׭ۜե\Ꞑ򲫕\쳁ɀֵٜ\❎ᩳ܅:\ˣƚE2ƒ׳\Ɓe𺵵6էn\୛=Eѭ\ӜǾ&gUWОHUB@\ȯS˺ӵ𜃜"IpW3\rޯ؛\ݜ盥cO,ėѿƲN8𜤟\̋e߻Ř!۰\ޜꣴAХ(RϏWW1񏜧צ5jx֡ݖԲOMն~\閑̲V\\fDƔ\蜧Ġ!Gۑۜ\ꝶªۛd˚)骂+Ƌ\ǫ́\󽑩ZÎ\"rҰ։񛜭Qݲ\nĐ)\쩤\n2Xΐ7:\nܭSSVpʽ\Ĝr^ԜϜᚋj(1񰻇\ӽCӇ֎5P\α۳ǖ\ﻡKȳ҉8\ʺ\뤜\Իʰկ%\秇𹽸ֻڜӋrĲ˄ǵ͍Џɿ\0󔟊\ۂ׺1]m¦˄ff\鎢\Ĝ순뫚6֌թ_/ёϵ]4𓘪a֙tҜnѼ޺֙\ҥۄʪ6ѥs´򔅲tߓ\Ԝ馹 cڱյ򩜮ކ֒(ԓ#Њrs\ܕ5\ͽ\ØϜ띈񃹜񞱆\໱\X\뫨]UYڶ!dcď\ꞜƎFߜ󷱕oܶ\켜ۜҢ͊dΘs򹾩x\؜ۤͤ򣜫ʜ'țY򵞜ȨV:¬X\ꃜ㊑߼񲜚}񜯴򭜙SgΜÅsɹLý*~Ǥ}\ɜԕ𾞜ӛYqߖѻٚe؍\r\՜̞>ʜn*լ2@\督̎;\鬜ɮȌĪgē\ܛܜƏ	,w͹Q=ݤ,G(H葇c\ӻ6pG㬋|\۵\ǜ󷀢\Ӈ\rJҐрQ\돰Ȝꝛ\f܃̉T˶Zٜ厂:+Ϲۜ۟ӟ˶9v\ݖ+Բ\ѕ@ѣGڜǹ\ֲΫŹƜ׀\ݤ\񃑚6ۜZDǆ\ˎ[$򏜧Կ\0m#Vۀ9\0=fӜߋQqh%ǹGQhQ\դPV𱜧=񜒁?^~ګ7ƒد՜'mĵ򈜇\㝪*۩Ux\Æ8󖣞8\Ӛ*ԣ򜩜㹻\ӜJc׍xޅN\˜߀sI9#\뎐L̇lx̜蝙k}\ڜԜ㪌\ҜŜ0lŲ\ݪվ\ƛޤڥچ\nՁr3ߤ󞼪Դnʚ`ŜԼ\뒜֎	򜣏¶ý6ݶ˂y5򲂮\Ĥٜ흊ų̫ͩ)´ڜƜɜȸԩ\ߜ耚ÆI\疸exω\ٶ\˜觪KxXDެޜǸ\ԟ\ëO\率]{ڶQCЬ9\ᵎ\鶰˄ҐD񨠙\ȗWPoМࠜﶞk>^Ӑа󞦍񻮜׼jH!֜룄:𿺷񵗹񧜧ι߬\բ)݄ݕӖG\娜Ѷ\䱜׼̜ٲ|T\ݭFWͰEHg\ܜԚZkנɕ^-!ԕ\r6S*\ܐubx𷏑Ͱ\̜娊C,i(񤵒U󠾜Z4iנ\ٚ?MɱAȞ󜰒\ƞ؜鯗ԦݜӜ̈𵓺񳜦@\套\躇߳𜗷ǈϜƇ\曕\Ӝ՜цY:\βǸ`}ӣF̧\Գձ͜㙖ޜ贼\ڡߘ2\ıqs󌷨=G۶{j✖k\ܫٶݾ8i\֖܆G\в?LГ֍\ZڎO\ܰ%nճ\\򹜄Fh\ۅ𾒱ۍLȶ\vцӜn\膱b$Yf\ꝋA޴h\՜؈F1>Ir֜Ʃ\䐟\\MI򜞜࡜ÁuŢ]peͺN>\ţFͭ̓\ΣɒCYլ{µ񜙷ȣ\ɇّ\\}8p=|ðz\L`4՜嚏\ׄ\鑪Ȝ˰\'K؉\\\\❘󚤫ɕ0	ќ͑f@򜐹Ϸ\ؓݡ\䖜毪󪈪\ꝙ򪜩aL󑁵\ȹ^>ڴj\뜢ڌȦ\랷}\寴\׵Ťޜ۝|ښȇɁ\岶\Мࠕ3nIb]m\ɜڜ曇b<ގΜZ]Ϝ杣Z\萱?󜙧,NULL),(2,3,'󜘿\ᜰJFIF\0\0\0\0\0\0󜛜0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342󜛜0C			\r\r2!!22222222222222222222222222222222222222222222222222󀜰􁟃\"\0󜄜0\0\0\0\0\0\0\0\0\0\0\0\0\0󜄜0A\0\0!1A\"QaqrѡѣBҰR񤢜ᖳr4%&\'CÓ󜄜0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0󜄜09\0\0\0\0!1AQ\"aq2q#Bѡ3RҰ$4Cñ5br󜚜0\0\0?\0\̍̈Н򵭜мU)͜0lQӐH\Zӹ犨&FOr+*u1e<񜢕ǁ~sޢ˫\0ñ\ɜ䝯W򺜭k22r{QET˄󹤜nqӡ×X\敜Ǚ 3˜䂜님@7\࠱ݕؠ \Z¬H\r۸mݩg+Ȁt󺜐eǐ7φ𛐎N񍹭ǜǜɟ՗PEӅ񤁠ÇlbܭA\'𪻜͑f\̆\Ď6Ò\Ʉ\ƝӼƀ؆0!1v(}*Ftݜr\ꀵĪЇ\Ǥ𦛜ݼΜՑՖq[Րϓ}g\զ͋\埜֢ӈǺԜɶŶK\晜Ȇ𲂐׆B¼à~񄶑݃$؇؀\м\Ԙ\"؛Ýև܏\寕֎\돚\ࠜ'I՜훜0\Ռ΀E񜈥цء.Z |RN;К٤ׂՕլʻeןݽˡ|񴥢əFA\͒Y0r|:΢ѱ1́#ˌ$*ғ߀򴁒pFҴWF\0rGjBe$ӫ֜喈íc\'N󵪰B\靛\縢4\j%sѱݪĢLȡӭ՜݉\Ҝӷ \n$! I;z\ZāĂWb78\Ñ򩯨\ݾ3ר\ȵfƞlж򕳜ۋlѼʙ%M`\ɜ⫓8R}\ճD[\˛\űי\ɘŵ\띌T\흥𦜜h\\5\؜ߜ☐\ܟձbc}\㏧񻓔ˉɡ񐲋5Qn&ΰSÙc%x̜흥\ӉcW ޱԞԮd\ʹM\ՁɜӜ权MҪ\村2וfҳʭ#> ٨N	#\¤d\řܨm\Ǩќ䊲֢A\Ȅ\弐ЊS1ЮYڿ)\ܜ࿜n\傷ɖD\׸_ZݵKڬ<\ʣV\줖򼳃\㨖ڰ\쬸ܜ`\Ӝͮ\ꝙQeʨR\ݖ@p\̏\䝉\̜UbEf\rƜ\҉dG$١؜r׵Ԏ7$ӐpqК˜Ƥ 7q\۸i̘\Չq\Ɛ\ѕ\ʓߢԓZי\r*qϭ	q\ӱbױȮʔqO\\߱M͸ɜޝ\Ɉp}ࠚ\カo٣ݛ\ќ٠G˜㵜Ƚ4ӭƴS@[ݑӁP؛@.\n\꣼ߩ؉\錿.äH\䜉\0\ӜiCq\ݜZӈˀͷ؁Toĵyݒ\ڤvR\6˜nF	r\ݜZܹʜɺͳSU\ߣ}ٜƝ٠\<Ù\ᝐ76ќ즰\ᱱ\ݓB\燃9򐜗`؈\岜͐ĆڬΰNƁ\오) 6{UIш-̎3^ǖ9\慷6ГAsլSː́aΜʘࠊe}&Zԩ	7Ͻ.`KѾƩ:\礜̹؞!w\αۜ꡷\nŁ$X\ᗈ?ȁӶ\ՐĘ\ؑެࠨ@󌰆ڀeΏھ\֠ɝɔ٣ԧƻ|\ļ}rj\̈\י𖜆Gz\徳6񖻮Ǧ?Ҍ^͞ϿĮ8\ܘ\0 \쉜歧dЂɞ08Ț,\Ĉ9؜1<m\Ũܪ.ٜr񁦝Μɶ¦ǟŢSѕ\"Мޑi}t\Ȥiޔ\ΦV!Ɣ!p7\ݜҎۂܹ !\ٜԋ۵ˌ\裌9J^٩ٌ𖭙ז%񜠂EղB\¸\˂w\ȱUӜѕɴ΀l򴜝vd̿\0Oٜݤɽ\ś\蒋\޹\0\ߜZ~<\˜᝭ص\Z<؈\޻ݧΜ\x\˜Ʒ!\Ϩxϡדlвzє[\쓦<\ꀜ\ѽ>G񜘜"Ĝ圧s˃\뉰\0\㰁𵼅٬𣀿xשKnǜۉdʜہ̟j_҃c\ɜ綜\W&[̸Pc񩞒\"δò@🚜еC\ҬéѼ(Υ1\伷؜Ԅį\⚳̪\琺!\ڜ夛y҅	g՜˜ǇB򞪵o.	³{\ל\z؀y=󜰴\ꝧퟹ󛁂ڡz͓	8\ϻ䏥ti\࠾򵭠ֶ=󍫄\ۜᘱ<ӥ\Z=\Ϝ地A=\ꔜ坂@=ԝ@\ۙ\c,0FF7ڇ ՜"ݜץob?xՎN\蚎ѷȜ\ɜ٬\gx¹\ǜߴmٜrmѱ򵜃Өlǹ׻&ڜڍ\Zܽwԋ۳\㭸υÜ爜φ\ḷʝ\၏px6X*\ؽϥ?P򎽜ɰh1\r^ȦS|ߡŜ내\0Ibw%:w\'#~{WĄ򈪜êtױɃѤਮл\"yȃΜʞ\ǒiҤб\Ƕ5bx¶(\̗;āȤKѵ\金ͩ\Ն\řLX1rҜܜݜзќ\J̇9\ܽ\띤ݝ\n8 \򵣑Ls܅\ƙӠӴ$+I#9\Ȝݜn\ϙǰôҜ蜰\ힼu\ߵ9Э
r	DqбѺP$𬼠N@#95g򀉔y8;ʍ͜ޤ򰜩=󄜌ǼϏe\ĀӪߜʜޜʔ+2򽍃<󄘝ۃ>\\qNƞ+3ӰI9\'$\ס\靭{̝󶉿ޚξh·\՜ͩ\܌`}+ۏ9ڌص1JTǶA\Оʜnv9\ǔ𢜮Ѩ9-»\⭜ǔ\ꜧ#}\ŕ	#ĪFݵ\Űڜꓜۜ"I\"jԁ؜npGc𨚤\0ߢV-Õ;\ڂ\饣𜠓߼\ԩK\ϾԥB͛\ǸZ󓄂RN\ȼ/5<2ӝ>TȾ\Ꝓr7Ťbʸ֨ٛԊ۫\ل̊	aМе\͆C1\пjݜ7̐qٮўp3߉\\nٞɹ@Cŧ?Bw58ye҃튰\rܜ퍜Ӯپ<KĶ\绚dUӔ:ٜˮ\廔͜؋ѾFTGWt~ɳB̜Z\应\䃏z\Гr7cڜA򿜫=غ?򿜩\Z$R\ͨHǟ\Ꝏ3˝x4ܸ󝩀GGF	$d\Z]|\뛜򭚜а\砜ሸ\蝭򢋧\䝅}Dэ诖ʜ[':سB𜒼G$͜㜑ɲ$˜ϔsŰiIͤ\5\͙߻\╖U&\ؿ\0ʽၬ&ʫbٜ0ǜ'ʋƜ߆Ҙȅ|Åv҈ІՕյ)ܒxX؉\ܜ΃ЮSʞܜ՜֜㶜շqؑ 𓧖\ŧ<sK۩?2Üf]F-\Ɓ́\ͭ\ꝭ̜坛# \Ҝ逜0~Һ󜰤󜰯\򻐥ߗχ9\쫗ĕ_0 ߇z2Id܅f؈ߔFМ懸=<n\ŷ򱘵\䓨ŌݻڳלZH؝ǆ\r\Zepȳ\ͷ\ח\ʿ݃\ԂѰaӰ65ܸݑĂA#|򼜒\ԜԴǨ	4g\\\򫳰h\?ĽնN75\ņF6\ɃjъЩؓ$e۹\nƜޜΫĜ끋x<𜒓̴\ڜ'ҿ࠲񙛜\͜䮰i\҆~񜡏\̜ۤc!\坚\߽ȡ򻗃,jϗ g\ԞƬ\Ʊ򎪎̈1j=Gq󜰟hЂ\'`F񠜑򣖜Ωρ𠜥:Б׎\ra؀ڔ𒹲Ĝ\͌0$񽦱6ՕG$H\ޭhAz¥2h]8ޘuKY`ԅĂHٰRƪ,֌騍ɜϪk2{X߄\Ἲ}М฽Œߖ\ꯜ坢)A܏󃻜Ԝ0pŜ띒7;\ѷ\\˜Ǖգ}莚m\㶗D\˹\Ӝd\繵ΎL\댄ϴ\ᮉշݎ\֜牝W\r𼜜󗵃\ރz.pރٺgܳŕʇ񣜖\ͱĚԙǒqׇ\陗D\ۀ5򥺎ࠈӨDw#I$Ȗ\κV͆Vښ\ށ:Lc=ț\Ջt\0\챃DYҶ/ǭc􇯲vΥ߅\됮ǎ;ӼܻƄ\巜α󢺔\сrʀ̛̺מԷȁ͈@č𳓖𖉼F҄Ӈ񜏕Lrz\ɱr*`𣲚\ɵ񶎮].n$թ\\Ӆ}ˀ\Ŕ\Ӈyɥ҆tϯR\"pŠ͕8&ڒ۩dЃ􇺹\Ǖʳ5Īi\ʇB1$}	׫\ܜވ\ъph;𢛇h2НƳҪܜɚ\϶EVP\լ˥s̜ќ㺒 \䂁s񪢔ӈ#ы?\Ômdoռ߬QŊۘȇ \䝫F]uwفܑ\眰\䝱𜛔\nǘԜ÷ψۻ߃˜и̬\ȜԴݏ򾕜nb=󺵜ݜゟֈ\Ͻiu𬼊Ŝ塜ᓦFĶNCCBJ񩣘sֵt\ڽLaǟ\ל鿏Ȩ:񶋢<\ڲ1ǡЎbѳҘU򕲂ٜ'óɡeB\靥p\ݷڣɪx\Ŷ\Ҝ䝮ӏȸj)J̓%ߥIŗ\rʈ \Ύ(\䱃 iݮ\鄲\܈FƠ񋜲!ƥ׹ĥx\Z(ͪ\餟\䝓~N\֖ؕҒԪ_8𱝽h3	T/	e;\듲	򕙜ˆ\ޖ?iࠜ0G\ű󻾾 W$ۖ>ٚު?΁$ԑۍRѣI<ЊŎZu\Å\'#5\̭𝜟Y\藟񰂼W򌜥ѭX񕎹z[4޴ƜɁ<bج0GȽR7ޅt˜'l\03ߜ0Ȝ謎ۘPٴ8𸟦6\ݜ֜ʱ.\靦1v\Ϫj\nڜƆ򱜮fςݗ:`򤀰p6ʮcJ\ꁄ\╂тsZל=C򜆜ӹҹ50Li\ƱI؋p<\ᝯLݵYԛaә\Z~j Nڸǜ뫒ݦǆ³\Ϝ㚵󜰜ꝧѣќǔۄ࠵(ےps𦝉t\儨ژݣեV͖򖜟񜣵5?\∟\rţ\룋܉ͮZ\Ї]\ɒ\r,\뀫\\ӤS{ש&񎛙\峵(ݞ5U Ȫת`1s9?	\ǎˀ\띧Ͱc͜ށ\⤀ɯʲ\̲ɓmЖƺ3n\nޜꝮ۴\Ȝ騇.SМ㊼_ݵÃi÷V#\렰ԭQnn\ۙaȒq\ݿ\0\旜ż\ȤɎCߜ՜ޜ0˜ݡ\0\rO\1BŲƜĜ䝌nc\ҳ\쀜0ٰ>򮜬򳉜Ӌ(:ׁ\ֻ͆sތ̶\㜺sRH\䤜Ⱥ\ꑜn\ퟕ22\噏w\듇Ӝټ{\ԛE\rfQ۹\ݾ𒛴מ>b\Ťި\蕜ǃ#񜣚٘\朰\СМɗJ̧޿q	>YԼ\Ϝqr\\؜㼔ݭ`RЧ˜ޜڜǜࠪą\܋ڜ\䝩\ȼֱĒۜӸα|vaPࠨϩ׹тB\㢳ݾtD=A,-æȜũϜ\\摭۽CȨ񜈜նQ޳ތ@.zaAퟍ𼱈TSɜهϳ:\龂yМʷQ׋ʡg*4\◃\쑄3ޘ񜨅߶\҆ćF#~qژZ\0\ޡ;/\՜겜끞ןǷɬ\Ҿ\שے\׹#(扶V6ˋٌMr]Hsϴ]ؿ*ؘ\ɿzſ\0\ʿs0φѽīʜͭđ<\͘\䏏lT̑J˓w5WP\0I\σ ն\'\˦	#zІŉ̿\0\Ɵҽ\尰ԅ߀\\ݜ֜ݼӣGlTfƜꄛ饜r\鎚˭$b\ʴќٲs\ꕁ:ޏ1˕>7󙕜౤RԀCd~ִEӥʒ6\ʐ}j\᪜rľƜࠜZו[ʩetV2(=ޔg@\杛󌉯X؜nv;󻜅񐦌򜍖\갯(ՙŘ\ɒ7cKP\oN&ƤՇבѹ\؟j\r*\׃Ѩ󜰉\湟U˯\혜ߝ\ɼʏ𜣾Tz]w:ɜZԑ \ŇɆݤ޷\Ņw!e\Ԝ᱃#Q_ڻ\ҐmQ\ųOֳdߐ\ٰ𜉮H9\ّ̜\ﱜٶW%ζ<\﷪\Ӿ+oΚG́١\μP[\0ȓ՜"\􍁘v@t`#ٜƒјҵ8׍9\Ŗ:|\߬&\ƣ/Đp5RO\ց<񜧯Ӯnb֜ժ\әb@\ٺ񊦎[veu##p{\ԨڄњKjϕ$\08\σc˓;Ӝđݶ5B\ڋ.UݢNA\Ⱥͩ0=wʜݶf\'9=ϭr\Џځ\ɜ߾񜊿\0\࠺\В࠸𿜒0Q\0Ã\ߛ\n\섹+\ǩӺ)!ջש]\❕rI9\ٮ+fԼ1󜟄Ͼ\ࠜꢿ\0Ï\ՙИcn\է\Ŷ:ګFi#e֜oJیƩde\ȤcjpeׂJ׌\ޜǙƣ\Ɯ로ܵ۵\Zg\׮\"\ƅbĴhٜr\ς򈨜Ģ\\jڙG\坓0̜~nr~֜ڜ♥dҜ˰􇖯֋𖆜睪(𞕶%\澥oSۅ\狽T񲜙X</(pr