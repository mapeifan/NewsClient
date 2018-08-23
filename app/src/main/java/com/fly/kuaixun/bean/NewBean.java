package com.fly.kuaixun.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewBean {

    /**
     * showapi_res_error :
     * showapi_res_code : 0
     * showapi_res_id : 2fecc6e77e32449eb8dfa206796702a7
     * showapi_res_body : {"ret_code":0,"pagebean":{"allPages":3923,"contentlist":[{"id":"11bcd8424aacb95c2881c8c750c9095e","pubDate":"2018-08-10 15:55:57","havePic":true,"channelName":"体育最新","title":"心理专栏：足球色彩的奥秘","desc":"。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=539743245,3047323600&fm=173&app=25&f=JPEG?w=532&h=348&s=1DD46F965D5771C20279D4CA03007033"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=3621523724,4704893&fm=173&app=25&f=JPEG?w=592&h=342&s=93A0F6A6CAF7CCD00A82F9BF03003009"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=1867586000,1544867947&fm=173&app=25&f=JPEG?w=640&h=352&s=48220FD2B6D93BC465987114030060F1"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1282909402,3201817727&fm=173&app=25&f=JPEG?w=640&h=339&s=805419CECAE18B764A4EB7BC0300D006"},{"height":0,"width":0,"url":"http://hiphotos.baidu.com/feed/pic/item/203fb80e7bec54e7d86ca955b5389b504ec26afd.jpg"}],"source":"硕博心理","channelId":"5572a109b3cdc86cf39001e6","nid":"9364951583514742705","link":"http://baijiahao.baidu.com/s?id=1606320576476912517&wfr=newsapp"},{"id":"d6d4a72800df6049b371d5e5d4bc31b7","pubDate":"2018-08-10 15:42:35","havePic":true,"channelName":"体育最新","title":"2018年北京市特奥足球周活动开赛","desc":"本次特奥足球周活动正值中国残联组织举办的第八届\u201c全国残疾人健身周\u201d期间。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=2793799455,3976013108&fm=173&app=25&f=JPEG?w=340&h=255&s=31A248B1441361C010B10F4C03005074"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1594819543,1268366400&fm=173&app=25&f=JPEG?w=639&h=440&s=A02AEEB148400ACA1A38596D03001057"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=2855605109,987658596&fm=173&app=25&f=JPEG?w=640&h=414&s=C87ABEF25E411AC07AB88C2D0300A077"}],"source":"华夏时报","channelId":"5572a109b3cdc86cf39001e6","nid":"9542195486493959986","link":"http://baijiahao.baidu.com/s?id=1608396640737796721&wfr=newsapp"},{"id":"00f21117206d2796653561bfdb52a535","pubDate":"2018-08-10 15:38:56","havePic":true,"channelName":"体育最新","title":"今夏，足球排球乒乓球羽毛球比赛的主题就一个字：快！","desc":"6月14日至7月15日进行的俄罗斯世界杯，给人留下最深刻印象的是法国队的姆巴佩。","imageurls":[{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1205611840,327507639&fm=173&app=25&f=JPEG?w=639&h=427&s=F184DB1C4E4370C4EC2898C70300B0A3"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=3562933916,771323242&fm=173&app=25&f=JPEG?w=640&h=427&s=F482DDBC4892B1E306856D380300C022"},{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=2110559763,2728085531&fm=173&app=25&f=JPEG?w=600&h=378&s=DC2C07D28135ABD63ADCD1A903007001"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=599226046,1705529560&fm=173&app=25&f=JPEG?w=640&h=426&s=0351AB6ECC1601D663D5311A0300C093"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1168080856,1165884106&fm=173&app=25&f=JPEG?w=500&h=365&s=80325D93D436319CDC19948D0300A0C3"}],"source":"真理是我亲戚","channelId":"5572a109b3cdc86cf39001e6","nid":"9239559583763689025","link":"http://baijiahao.baidu.com/s?id=1608380090441986633&wfr=newsapp"},{"id":"42055a789a9e1b8cb57c5569c04d58f7","pubDate":"2018-08-10 15:27:31","havePic":true,"channelName":"国际焦点","title":"朝鲜工人足球队抵达韩国：举统一旗 戴领袖徽章","desc":"8月10日，朝鲜代表团抵达韩国，挥舞统一旗。（韩联社）　　海外网8月10日电 当地时间10日上午，64人的朝鲜代表团在朝鲜职业总同盟委员长率领下，经由陆路抵达韩国，准备参加10日至12日在韩国举行的韩朝统一工人足球运动会。图为朝鲜职业总同盟委员长。（韩联社）　　据韩....","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/575/w550h825/20180810/B5_R-hhnunsq8170873.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/116/w550h366/20180810/OyY6-hhnunsq8170975.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/116/w550h366/20180810/3Wvk-hhnunsq8171094.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/98/w550h348/20180810/EwQb-hhnunsq8171508.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/755/w500h255/20180810/GRjA-hhnunsq8171569.jpg"}],"source":"新浪","channelId":"5572a108b3cdc86cf39001ce","link":"http://news.sina.com.cn/w/2018-08-10/doc-ihhnunsq8174015.shtml"},{"id":"d723e3e98ccf255ec516b453902f3625","pubDate":"2018-08-10 15:20:46","havePic":true,"channelName":"体育最新","title":"麦当劳与英足总续约至2022年，继续深耕英国基层足球领域","desc":"20年的合作时间也让麦当劳成为英国基层足球界，资历最老的合作伙伴。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=701262345,1725488669&fm=173&app=25&f=JPEG?w=640&h=323&s=98B5419696E5A4E81E0B2EAF0300800E"}],"source":"懒熊体育","channelId":"5572a109b3cdc86cf39001e6","nid":"8887754607779830840","link":"http://baijiahao.baidu.com/s?id=1608393862836344240&wfr=newsapp"}],"currentPage":1,"allNum":19613,"maxResult":5}}
     */

    private String showapi_res_error;
    private int showapi_res_code;
    private String showapi_res_id;
    private ShowapiResBodyBean showapi_res_body;

    public static NewBean objectFromData(String str) {

        return new Gson().fromJson(str, NewBean.class);
    }

    public static NewBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NewBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NewBean> arrayNewBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NewBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NewBean> arrayNewBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NewBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_id() {
        return showapi_res_id;
    }

    public void setShowapi_res_id(String showapi_res_id) {
        this.showapi_res_id = showapi_res_id;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * pagebean : {"allPages":3923,"contentlist":[{"id":"11bcd8424aacb95c2881c8c750c9095e","pubDate":"2018-08-10 15:55:57","havePic":true,"channelName":"体育最新","title":"心理专栏：足球色彩的奥秘","desc":"。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=539743245,3047323600&fm=173&app=25&f=JPEG?w=532&h=348&s=1DD46F965D5771C20279D4CA03007033"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=3621523724,4704893&fm=173&app=25&f=JPEG?w=592&h=342&s=93A0F6A6CAF7CCD00A82F9BF03003009"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=1867586000,1544867947&fm=173&app=25&f=JPEG?w=640&h=352&s=48220FD2B6D93BC465987114030060F1"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1282909402,3201817727&fm=173&app=25&f=JPEG?w=640&h=339&s=805419CECAE18B764A4EB7BC0300D006"},{"height":0,"width":0,"url":"http://hiphotos.baidu.com/feed/pic/item/203fb80e7bec54e7d86ca955b5389b504ec26afd.jpg"}],"source":"硕博心理","channelId":"5572a109b3cdc86cf39001e6","nid":"9364951583514742705","link":"http://baijiahao.baidu.com/s?id=1606320576476912517&wfr=newsapp"},{"id":"d6d4a72800df6049b371d5e5d4bc31b7","pubDate":"2018-08-10 15:42:35","havePic":true,"channelName":"体育最新","title":"2018年北京市特奥足球周活动开赛","desc":"本次特奥足球周活动正值中国残联组织举办的第八届\u201c全国残疾人健身周\u201d期间。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=2793799455,3976013108&fm=173&app=25&f=JPEG?w=340&h=255&s=31A248B1441361C010B10F4C03005074"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1594819543,1268366400&fm=173&app=25&f=JPEG?w=639&h=440&s=A02AEEB148400ACA1A38596D03001057"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=2855605109,987658596&fm=173&app=25&f=JPEG?w=640&h=414&s=C87ABEF25E411AC07AB88C2D0300A077"}],"source":"华夏时报","channelId":"5572a109b3cdc86cf39001e6","nid":"9542195486493959986","link":"http://baijiahao.baidu.com/s?id=1608396640737796721&wfr=newsapp"},{"id":"00f21117206d2796653561bfdb52a535","pubDate":"2018-08-10 15:38:56","havePic":true,"channelName":"体育最新","title":"今夏，足球排球乒乓球羽毛球比赛的主题就一个字：快！","desc":"6月14日至7月15日进行的俄罗斯世界杯，给人留下最深刻印象的是法国队的姆巴佩。","imageurls":[{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1205611840,327507639&fm=173&app=25&f=JPEG?w=639&h=427&s=F184DB1C4E4370C4EC2898C70300B0A3"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=3562933916,771323242&fm=173&app=25&f=JPEG?w=640&h=427&s=F482DDBC4892B1E306856D380300C022"},{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=2110559763,2728085531&fm=173&app=25&f=JPEG?w=600&h=378&s=DC2C07D28135ABD63ADCD1A903007001"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=599226046,1705529560&fm=173&app=25&f=JPEG?w=640&h=426&s=0351AB6ECC1601D663D5311A0300C093"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1168080856,1165884106&fm=173&app=25&f=JPEG?w=500&h=365&s=80325D93D436319CDC19948D0300A0C3"}],"source":"真理是我亲戚","channelId":"5572a109b3cdc86cf39001e6","nid":"9239559583763689025","link":"http://baijiahao.baidu.com/s?id=1608380090441986633&wfr=newsapp"},{"id":"42055a789a9e1b8cb57c5569c04d58f7","pubDate":"2018-08-10 15:27:31","havePic":true,"channelName":"国际焦点","title":"朝鲜工人足球队抵达韩国：举统一旗 戴领袖徽章","desc":"8月10日，朝鲜代表团抵达韩国，挥舞统一旗。（韩联社）　　海外网8月10日电 当地时间10日上午，64人的朝鲜代表团在朝鲜职业总同盟委员长率领下，经由陆路抵达韩国，准备参加10日至12日在韩国举行的韩朝统一工人足球运动会。图为朝鲜职业总同盟委员长。（韩联社）　　据韩....","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/575/w550h825/20180810/B5_R-hhnunsq8170873.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/116/w550h366/20180810/OyY6-hhnunsq8170975.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/116/w550h366/20180810/3Wvk-hhnunsq8171094.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/98/w550h348/20180810/EwQb-hhnunsq8171508.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/755/w500h255/20180810/GRjA-hhnunsq8171569.jpg"}],"source":"新浪","channelId":"5572a108b3cdc86cf39001ce","link":"http://news.sina.com.cn/w/2018-08-10/doc-ihhnunsq8174015.shtml"},{"id":"d723e3e98ccf255ec516b453902f3625","pubDate":"2018-08-10 15:20:46","havePic":true,"channelName":"体育最新","title":"麦当劳与英足总续约至2022年，继续深耕英国基层足球领域","desc":"20年的合作时间也让麦当劳成为英国基层足球界，资历最老的合作伙伴。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=701262345,1725488669&fm=173&app=25&f=JPEG?w=640&h=323&s=98B5419696E5A4E81E0B2EAF0300800E"}],"source":"懒熊体育","channelId":"5572a109b3cdc86cf39001e6","nid":"8887754607779830840","link":"http://baijiahao.baidu.com/s?id=1608393862836344240&wfr=newsapp"}],"currentPage":1,"allNum":19613,"maxResult":5}
         */

        private int ret_code;
        private PagebeanBean pagebean;

        public static ShowapiResBodyBean objectFromData(String str) {

            return new Gson().fromJson(str, ShowapiResBodyBean.class);
        }

        public static ShowapiResBodyBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ShowapiResBodyBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ShowapiResBodyBean> arrayShowapiResBodyBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ShowapiResBodyBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ShowapiResBodyBean> arrayShowapiResBodyBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ShowapiResBodyBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean {
            /**
             * allPages : 3923
             * contentlist : [{"id":"11bcd8424aacb95c2881c8c750c9095e","pubDate":"2018-08-10 15:55:57","havePic":true,"channelName":"体育最新","title":"心理专栏：足球色彩的奥秘","desc":"。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=539743245,3047323600&fm=173&app=25&f=JPEG?w=532&h=348&s=1DD46F965D5771C20279D4CA03007033"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=3621523724,4704893&fm=173&app=25&f=JPEG?w=592&h=342&s=93A0F6A6CAF7CCD00A82F9BF03003009"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=1867586000,1544867947&fm=173&app=25&f=JPEG?w=640&h=352&s=48220FD2B6D93BC465987114030060F1"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1282909402,3201817727&fm=173&app=25&f=JPEG?w=640&h=339&s=805419CECAE18B764A4EB7BC0300D006"},{"height":0,"width":0,"url":"http://hiphotos.baidu.com/feed/pic/item/203fb80e7bec54e7d86ca955b5389b504ec26afd.jpg"}],"source":"硕博心理","channelId":"5572a109b3cdc86cf39001e6","nid":"9364951583514742705","link":"http://baijiahao.baidu.com/s?id=1606320576476912517&wfr=newsapp"},{"id":"d6d4a72800df6049b371d5e5d4bc31b7","pubDate":"2018-08-10 15:42:35","havePic":true,"channelName":"体育最新","title":"2018年北京市特奥足球周活动开赛","desc":"本次特奥足球周活动正值中国残联组织举办的第八届\u201c全国残疾人健身周\u201d期间。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=2793799455,3976013108&fm=173&app=25&f=JPEG?w=340&h=255&s=31A248B1441361C010B10F4C03005074"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1594819543,1268366400&fm=173&app=25&f=JPEG?w=639&h=440&s=A02AEEB148400ACA1A38596D03001057"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=2855605109,987658596&fm=173&app=25&f=JPEG?w=640&h=414&s=C87ABEF25E411AC07AB88C2D0300A077"}],"source":"华夏时报","channelId":"5572a109b3cdc86cf39001e6","nid":"9542195486493959986","link":"http://baijiahao.baidu.com/s?id=1608396640737796721&wfr=newsapp"},{"id":"00f21117206d2796653561bfdb52a535","pubDate":"2018-08-10 15:38:56","havePic":true,"channelName":"体育最新","title":"今夏，足球排球乒乓球羽毛球比赛的主题就一个字：快！","desc":"6月14日至7月15日进行的俄罗斯世界杯，给人留下最深刻印象的是法国队的姆巴佩。","imageurls":[{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1205611840,327507639&fm=173&app=25&f=JPEG?w=639&h=427&s=F184DB1C4E4370C4EC2898C70300B0A3"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=3562933916,771323242&fm=173&app=25&f=JPEG?w=640&h=427&s=F482DDBC4892B1E306856D380300C022"},{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=2110559763,2728085531&fm=173&app=25&f=JPEG?w=600&h=378&s=DC2C07D28135ABD63ADCD1A903007001"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=599226046,1705529560&fm=173&app=25&f=JPEG?w=640&h=426&s=0351AB6ECC1601D663D5311A0300C093"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1168080856,1165884106&fm=173&app=25&f=JPEG?w=500&h=365&s=80325D93D436319CDC19948D0300A0C3"}],"source":"真理是我亲戚","channelId":"5572a109b3cdc86cf39001e6","nid":"9239559583763689025","link":"http://baijiahao.baidu.com/s?id=1608380090441986633&wfr=newsapp"},{"id":"42055a789a9e1b8cb57c5569c04d58f7","pubDate":"2018-08-10 15:27:31","havePic":true,"channelName":"国际焦点","title":"朝鲜工人足球队抵达韩国：举统一旗 戴领袖徽章","desc":"8月10日，朝鲜代表团抵达韩国，挥舞统一旗。（韩联社）　　海外网8月10日电 当地时间10日上午，64人的朝鲜代表团在朝鲜职业总同盟委员长率领下，经由陆路抵达韩国，准备参加10日至12日在韩国举行的韩朝统一工人足球运动会。图为朝鲜职业总同盟委员长。（韩联社）　　据韩....","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/575/w550h825/20180810/B5_R-hhnunsq8170873.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/116/w550h366/20180810/OyY6-hhnunsq8170975.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/116/w550h366/20180810/3Wvk-hhnunsq8171094.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/98/w550h348/20180810/EwQb-hhnunsq8171508.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/news/crawl/755/w500h255/20180810/GRjA-hhnunsq8171569.jpg"}],"source":"新浪","channelId":"5572a108b3cdc86cf39001ce","link":"http://news.sina.com.cn/w/2018-08-10/doc-ihhnunsq8174015.shtml"},{"id":"d723e3e98ccf255ec516b453902f3625","pubDate":"2018-08-10 15:20:46","havePic":true,"channelName":"体育最新","title":"麦当劳与英足总续约至2022年，继续深耕英国基层足球领域","desc":"20年的合作时间也让麦当劳成为英国基层足球界，资历最老的合作伙伴。","imageurls":[{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=701262345,1725488669&fm=173&app=25&f=JPEG?w=640&h=323&s=98B5419696E5A4E81E0B2EAF0300800E"}],"source":"懒熊体育","channelId":"5572a109b3cdc86cf39001e6","nid":"8887754607779830840","link":"http://baijiahao.baidu.com/s?id=1608393862836344240&wfr=newsapp"}]
             * currentPage : 1
             * allNum : 19613
             * maxResult : 5
             */

            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;
            private List<ContentlistBean> contentlist;

            public static PagebeanBean objectFromData(String str) {

                return new Gson().fromJson(str, PagebeanBean.class);
            }

            public static PagebeanBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), PagebeanBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<PagebeanBean> arrayPagebeanBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<PagebeanBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<PagebeanBean> arrayPagebeanBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<PagebeanBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                /**
                 * id : 11bcd8424aacb95c2881c8c750c9095e
                 * pubDate : 2018-08-10 15:55:57
                 * havePic : true
                 * channelName : 体育最新
                 * title : 心理专栏：足球色彩的奥秘
                 * desc : 。
                 * imageurls : [{"height":0,"width":0,"url":"http://t10.baidu.com/it/u=539743245,3047323600&fm=173&app=25&f=JPEG?w=532&h=348&s=1DD46F965D5771C20279D4CA03007033"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=3621523724,4704893&fm=173&app=25&f=JPEG?w=592&h=342&s=93A0F6A6CAF7CCD00A82F9BF03003009"},{"height":0,"width":0,"url":"http://t12.baidu.com/it/u=1867586000,1544867947&fm=173&app=25&f=JPEG?w=640&h=352&s=48220FD2B6D93BC465987114030060F1"},{"height":0,"width":0,"url":"http://t11.baidu.com/it/u=1282909402,3201817727&fm=173&app=25&f=JPEG?w=640&h=339&s=805419CECAE18B764A4EB7BC0300D006"},{"height":0,"width":0,"url":"http://hiphotos.baidu.com/feed/pic/item/203fb80e7bec54e7d86ca955b5389b504ec26afd.jpg"}]
                 * source : 硕博心理
                 * channelId : 5572a109b3cdc86cf39001e6
                 * nid : 9364951583514742705
                 * link : http://baijiahao.baidu.com/s?id=1606320576476912517&wfr=newsapp
                 */

                private String id;
                private String pubDate;
                private boolean havePic;
                private String channelName;
                private String title;
                private String desc;
                private String source;
                private String channelId;
                private String nid;
                private String link;
                private List<ImageurlsBean> imageurls;

                public static ContentlistBean objectFromData(String str) {

                    return new Gson().fromJson(str, ContentlistBean.class);
                }

                public static ContentlistBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ContentlistBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ContentlistBean> arrayContentlistBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ContentlistBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ContentlistBean> arrayContentlistBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ContentlistBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPubDate() {
                    return pubDate;
                }

                public void setPubDate(String pubDate) {
                    this.pubDate = pubDate;
                }

                public boolean isHavePic() {
                    return havePic;
                }

                public void setHavePic(boolean havePic) {
                    this.havePic = havePic;
                }

                public String getChannelName() {
                    return channelName;
                }

                public void setChannelName(String channelName) {
                    this.channelName = channelName;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getChannelId() {
                    return channelId;
                }

                public void setChannelId(String channelId) {
                    this.channelId = channelId;
                }

                public String getNid() {
                    return nid;
                }

                public void setNid(String nid) {
                    this.nid = nid;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public List<ImageurlsBean> getImageurls() {
                    return imageurls;
                }

                public void setImageurls(List<ImageurlsBean> imageurls) {
                    this.imageurls = imageurls;
                }

                public static class ImageurlsBean {
                    /**
                     * height : 0
                     * width : 0
                     * url : http://t10.baidu.com/it/u=539743245,3047323600&fm=173&app=25&f=JPEG?w=532&h=348&s=1DD46F965D5771C20279D4CA03007033
                     */

                    private int height;
                    private int width;
                    private String url;

                    public static ImageurlsBean objectFromData(String str) {

                        return new Gson().fromJson(str, ImageurlsBean.class);
                    }

                    public static ImageurlsBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), ImageurlsBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<ImageurlsBean> arrayImageurlsBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<ImageurlsBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<ImageurlsBean> arrayImageurlsBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<ImageurlsBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }
    }
}
