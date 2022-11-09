package com.mohammedalmajhali.aladhkar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link list_adhkar_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class list_adhkar_fragment extends DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    // الاول هو رقم الزر
    private int mParam1;
    // الثاني هو الوقت صباح او مساء
    private int mParam2;

    // نعرف مصفوفة البيانات الذي بانرسلها الى الادابتر
    ArrayList<Dekr> data_adhkar;


    RecyclerView rv_adkar;
    onDhekrClicked listener;

    // الكونستركتر مطلوب من عندهم
    public list_adhkar_fragment() {
        // Required empty public constructor
    }


    // هذه اول داله تتنفذ وتجيب لي الكونتكس حق الاكتفتي اللي فتحت الفراقمنت
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // افول له الليسنر اللي معي يساوي الاكتفي ، لان انا سويت له implementation هناك وبعدين تحت با استدعي الداله اللي داخله متى ما اريد
        listener = (onDhekrClicked) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment list_adhkar_fragment.
     */
    // TODO: Rename and change types and number of parameters


    public static list_adhkar_fragment newInstance(String param1, String param2) {
        list_adhkar_fragment fragment = new list_adhkar_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = Integer.parseInt(getArguments().getString(ARG_PARAM1));
            mParam2 = Integer.parseInt(getArguments().getString(ARG_PARAM2));


            // نجهز المصفوفة ونعبيها بيانات
            data_adhkar = new ArrayList<>();

            switch (mParam1) {

                case SectionsActivity.NUM_btn_istiaah_and_basmalah:

                    data_adhkar.add(new Dekr(0,3,
                            "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ الْهَمِّ وَالْحَزَنِ، وَأَعُوذُ بِكَ مِنْ الْعَجْزِ وَالْكَسَلِ، وَأَعُوذُ بِكَ مِنْ الْجُبْنِ وَالْبُخْلِ، وَأَعُوذُ بِكَ مِنْ غَلَبَةِ الدَّيْنِ، وَقَهْرِ الرِّجَالِ.",
                            "جاء من حديث أنس بن مالكٍ -رضي الله تعالى عنه- قال: كان النبيُّ ﷺ يقول: (اللهم إني أعوذ بك من الهمِّ والحزن، والعجز والكسل، والجبن والبخل، وضلع الدَّين، وغلبة الرِّجال)"));
                    data_adhkar.add(new Dekr(1,3,
                            "اللَّهُمَّ إِنَّا نَعُوذُ بِكَ مِنْ أَنْ نُشْرِكَ بِكَ شَيْئاً نَعْلَمُهُ ، وَنَسْتَغْفِرُكَ لِمَا لَا نَعْلَمُهُ.",
                            "عن أبي موسى الأشعري قال: خطبنا رسول الله صلى الله عليه وسلم ذات يوم فقال: يا أيها الناس اتقوا هذا الشرك، فإنه أخفى من دبيب النمل. فقال له من شاء الله أن يقول: وكيف نتقيه وهو أخفى من دبيب النمل يا رسول الله ؟ قال: قولوا: اللهم إنا نعوذ بك ...' . "));
                    data_adhkar.add(new Dekr(2,3,
                            "أَعـوذُ بِكَلِمـاتِ اللّهِ التّـامّـاتِ مِنْ شَـرِّ ما خَلَـق.",
                            "عَنْ أَبِي هُرَيْرَةَ ، أَنَّهُ قَالَ : جَاءَ رَجُلٌ إِلَى النَّبِيِّ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ فَقَالَ : يَا رَسُولَ اللهِ مَا لَقِيتُ مِنْ عَقْرَبٍ لَدَغَتْنِي الْبَارِحَةَ ، قَالَ : ( أَمَا لَوْ قُلْتَ ، حِينَ أَمْسَيْتَ : أَعُوذُ بِكَلِمَاتِ اللهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ ، لَمْ تَضُرَّكَ )"));
                    data_adhkar.add(new Dekr(3,3,
                            "بِسـمِ اللهِ الذي لا يَضُـرُّ مَعَ اسمِـهِ شَيءٌ في الأرْضِ وَلا في السّمـاءِ وَهـوَ السّمـيعُ العَلـيم.",
                            "عن عثمان بن عفان رضي الله عنه قال: قال رسول الله ﷺ : ( من قال: '...' ، ثلاث مرات، لم تصبه فجأةُ بلاء حتى يُصبح، ومن قالها حين يُصبح ثلاث مرات لم تصبه فجأةُ بلاء حتى يُمسي )."));
                    data_adhkar.add(new Dekr(4,1,
                            "اللّهُـمَّ عالِـمَ الغَـيْبِ وَالشّـهادَةِ فاطِـرَ السّماواتِ وَالأرْضِ رَبَّ كـلِّ شَـيءٍ وَمَليـكَه ، أَشْهَـدُ أَنْ لا إِلـهَ إِلاّ أَنْت ، أَعـوذُ بِكَ مِن شَـرِّ نَفْسـي وَمِن شَـرِّ الشَّيْـطانِ وَشِـرْكِه ، وَأَنْ أَقْتَـرِفَ عَلـى نَفْسـي سوءاً أَوْ أَجُـرَّهُ إِلـى مُسْـلِم.",
                            "عن أبي هريرة أَنَّ أَبا بَكرٍ الصِّدِّيقَ، \uF074، قَالَ: يَا رَسُولَ اللَّهِ مُرْنِي بِكَلمَاتٍ أَقُولُهُنَّ إِذَا أَصْبَحْتُ وإِذَا أَمْسَيتُ، قَالَ: (قُلْ: اللَّهُمَّ فَاطِرَ السَّمَواتِ والأرضِ عَالمَ الغَيْب وَالشَّهَادةِ،... \" قَالَ: \"قُلْها إِذا أَصْبحْتَ، وَإِذا أَمْسَيْتَ، وإِذا أَخذْتَ مَضْجِعَكَ) "));

                    break;
                case SectionsActivity.NUM_btn_evening_morning:
                    if (mParam2 == MainActivity.MORNING) {

                        data_adhkar.add(new Dekr(5,1,
                                "أَصْـبَحْنا وَأَصْـبَحَ المُـلْكُ لله وَالحَمدُ لله ، لا إلهَ إلاّ اللّهُ وَحدَهُ لا شَريكَ لهُ، لهُ المُـلكُ ولهُ الحَمْـد، وهُوَ على كلّ شَيءٍ قدير ، رَبِّ أسْـأَلُـكَ خَـيرَ ما في هـذا اليوم وَخَـيرَ ما بَعْـدَه ، وَأَعـوذُ بِكَ مِنْ شَـرِّ ما في هـذا اليوم وَشَرِّ ما بَعْـدَه، رَبِّ أَعـوذُ بِكَ مِنَ الْكَسَـلِ وَسـوءِ الْكِـبَر ، رَبِّ أَعـوذُ بِكَ مِنْ عَـذابٍ في النّـارِ وَعَـذابٍ في القَـبْر.",
                                "كان نبيُّ الله ﷺ إذا أمسى او اصبح قاله"));
                        data_adhkar.add(new Dekr(6,1,
                                "أَصْبَـحْـنا وَأَصْبَـحْ المُـلكُ للهِ رَبِّ العـالَمـين ، اللّهُـمَّ إِنِّـي أسْـأَلُـكَ خَـيْرَ هـذا الـيَوْم ، فَـتْحَهُ ، وَنَصْـرَهُ ، وَنـورَهُ وَبَـرَكَتَـهُ ، وَهُـداهُ ، وَأَعـوذُ بِـكَ مِـنْ شَـرِّ ما فـيهِ وَشَـرِّ ما بَعْـدَه.",
                                "قال رسول الله ﷺ إذا أصبح أحدكم فليقل أصبحنا وأصبح الملك لله رب العالمين ... ثم إذا أمسى فليقل مثل ذلك. "));
                        data_adhkar.add(new Dekr(7,1,
                                "اللّهُـمَّ بِكَ أَصْـبَحْنا وَبِكَ أَمْسَـينا ، وَبِكَ نَحْـيا وَبِ,كَ نَمُـوتُ وَإِلَـيْكَ النُّـشُور.",
                                "كان رسول الله صلى الله عليه وسلم يعلم أصحابه يقول إذا أصبح أحدكم فليقل اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك المصير وإذا أمسى فليقل اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك النشور"));
                        data_adhkar.add(new Dekr(8,1,
                                "اللّهُـمَّ ما أَصْبَـَحَ بي مِـنْ نِعْـمَةٍ أَو بِأَحَـدٍ مِـنْ خَلْـقِك ، فَمِـنْكَ وَحْـدَكَ لا شريكَ لَـك ، فَلَـكَ الْحَمْـدُ وَلَـكَ الشُّكْـر.",
                                " من قالها حين يصبح فقد أدى شكر يومه ومن قالها حين يمسي فقد أدى شكر ليلته"));
                        data_adhkar.add(new Dekr(9,4,
                                "اللّهُـمَّ إِنِّـي أَصْبَـحْتُ أُشْـهِدُك ، وَأُشْـهِدُ حَمَلَـةَ عَـرْشِـك ، وَمَلائِكَتِك ، وَجَمـيعَ خَلْـقِك ، أَنَّـكَ أَنْـتَ اللهُ لا إلهَ إلاّ أَنْـتَ وَحْـدَكَ لا شَريكَ لَـك ، وَأَنَّ مُحَمّـداً عَبْـدُكَ وَرَسـولُـك.",
                                "من قالها حين يصبح أو يمسي: أربع مرات أعتقه الله من النار"));
                        data_adhkar.add(new Dekr(10,1,
                                "أَصْبَـحْـنا عَلَى فِطْرَةِ الإسْلاَمِ، وَعَلَى كَلِمَةِ الإِخْلاَصِ، وَعَلَى دِينِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ، وَعَلَى مِلَّةِ أَبِينَا إبْرَاهِيمَ حَنِيفاً مُسْلِماً وَمَا كَانَ مِنَ المُشْرِكِينَ.",
                                " عن أبي بن كعب قال كان رسول الله صلى الله عليه وسلم يعلمنا إذا أصبحنا أصبحنا على '...' وإذا أمسينا مثل ذلك"));
                    }
                    else {
                        data_adhkar.add(new Dekr(5,1,
                                "أَمْسَيْـنا وَأَمْسـى المـلكُ لله وَالحَمدُ لله ، لا إلهَ إلاّ اللّهُ وَحدَهُ لا شَريكَ لهُ، لهُ المُـلكُ ولهُ الحَمْـد، وهُوَ على كلّ شَيءٍ قدير ، رَبِّ أسْـأَلُـكَ خَـيرَ ما في هـذهِ اللَّـيْلَةِ وَخَـيرَ ما بَعْـدَهـا ، وَأَعـوذُ بِكَ مِنْ شَـرِّ ما في هـذهِ اللَّـيْلةِ وَشَرِّ ما بَعْـدَهـا ، رَبِّ أَعـوذُبِكَ مِنَ الْكَسَـلِ وَسـوءِ الْكِـبَر ، رَبِّ أَعـوذُبِكَ مِنْ عَـذابٍ في النّـارِ وَعَـذابٍ في القَـبْر.",
                                "كان نبيُّ الله ﷺ إذا أمسى او اصبح قاله"));
                        data_adhkar.add(new Dekr(6,1,
                                "أَمْسَيْنا وَأَمْسَى الْمُلْكُ للهِ رَبِّ الْعَالَمَيْنِ، اللَّهُمَّ إِنَّي أسْأَلُكَ خَيْرَ هَذَه اللَّيْلَةِ فَتْحُهَا وَنُصَرُّهَا، وَنورَهُا و برَكَتَهُا، وَهُداهُا، وَأَعُوذُ بِكَ مِنْ شَرِّ مَا فيهِا وَشَرَّ مَا بَعْدَهَا.",
                                "قال رسول الله ﷺ إذا أصبح أحدكم فليقل أصبحنا وأصبح الملك لله رب العالمين ... ثم إذا أمسى فليقل مثل ذلك. "));
                        data_adhkar.add(new Dekr(7,1,
                                "اللّهُـمَّ بِكَ أَمْسَـينا وَبِكَ أَصْـبَحْنا، وَبِكَ نَحْـيا وَبِكَ نَمُـوتُ وَإِلَـيْكَ الْمَصِيرُ.",
                                "كان رسول الله صلى الله عليه وسلم يعلم أصحابه يقول إذا أصبح أحدكم فليقل اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك المصير وإذا أمسى فليقل اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك النشور"));
                        data_adhkar.add(new Dekr(8,1,
                                "اللّهُـمَّ ما أَمسى بي مِـنْ نِعْـمَةٍ أَو بِأَحَـدٍ مِـنْ خَلْـقِك ، فَمِـنْكَ وَحْـدَكَ لا شريكَ لَـك ، فَلَـكَ الْحَمْـدُ وَلَـكَ الشُّكْـر.",
                                " من قالها حين يصبح فقد أدى شكر يومه ومن قالها حين يمسي فقد أدى شكر ليلته"));
                        data_adhkar.add(new Dekr(9,4,
                                "اللّهُـمَّ إِنِّـي أَمسيتُ أُشْـهِدُك ، وَأُشْـهِدُ حَمَلَـةَ عَـرْشِـك ، وَمَلائِكَتِك ، وَجَمـيعَ خَلْـقِك ، أَنَّـكَ أَنْـتَ اللهُ لا إلهَ إلاّ أَنْـتَ وَحْـدَكَ لا شَريكَ لَـك ، وَأَنَّ ُ مُحَمّـداً عَبْـدُكَ وَرَسـولُـك.",
                                "من قالها أربع مرات حين يمسي أو يصبح أعتقه الله من النار"));
                        data_adhkar.add(new Dekr(10,1,
                                "أَمْسَيْنَا عَلَى فِطْرَةِ الإسْلاَمِ، وَعَلَى كَلِمَةِ الإِخْلاَصِ، وَعَلَى دِينِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ، وَعَلَى مِلَّةِ أَبِينَا إبْرَاهِيمَ حَنِيفاً مُسْلِماً وَمَا كَانَ مِنَ المُشْرِكِينَ.",
                                " عن أبي بن كعب قال كان رسول الله صلى الله عليه وسلم يعلمنا إذا أصبحنا أصبحنا على '...' وإذا أمسينا مثل ذلك"));
                    }
                    break;
                case SectionsActivity.NUM_btn_quran:
                    data_adhkar.add(new Dekr(11,1,
                            "اللّهُ لاَ إِلَـهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ لَّهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الأَرْضِ مَن ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلاَّ بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلاَ يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلاَّ بِمَا شَاءَ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالأَرْضَ وَلاَ يَؤُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ.",
                            "من قرأها حين يصبح أجير من الجن حتى يمسي ومن قرأها حين يسمي أجير من الجن حتى يصبح"));

                    if (mParam2 == MainActivity.EVENING) {
                        data_adhkar.add(new Dekr(12,1,
                                "آمَنَ الرَّسُولُ بِمَا أُنْزِلَ إِلَيْهِ مِنْ رَبِّهِ وَالْمُؤْمِنُونَ ۚ كُلٌّ آمَنَ بِاللَّهِ وَمَلَائِكَتِهِ وَكُتُبِهِ وَرُسُلِهِ لَا نُفَرِّقُ بَيْنَ أَحَدٍ مِنْ رُسُلِهِ ۚ وَقَالُوا سَمِعْنَا وَأَطَعْنَا ۖ غُفْرَانَكَ رَبَّنَا وَإِلَيْكَ الْمَصِيرُ. لَا يُكَلِّفُ اللَّهُ نَفْسًا إِلَّا وُسْعَهَا لَهَا مَا كَسَبَتْ وَعَلَيْهَا مَا اكْتَسَبَتْ رَبَّنَا لَا تُؤَاخِذْنَا إِنْ نَسِينَا أَوْ أَخْطَأْنَا رَبَّنَا وَلَا تَحْمِلْ عَلَيْنَا إِصْرًا كَمَا حَمَلْتَهُ عَلَى الَّذِينَ مِنْ قَبْلِنَا رَبَّنَا وَلَا تُحَمِّلْنَا مَا لَا طَاقَةَ لَنَا بِهِ وَاعْفُ عَنَّا وَاغْفِرْ لَنَا وَارْحَمْنَا أَنْتَ مَوْلَانَا فَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِينَ.",
                                "قال رسول الله ﷺ (من قرأ بالآيتين من آخر سورة البقرة في ليلة كفتاه). أي كفَتَاه المَكْرُوهَ تِلك اللَّيْلَة" ));
                    }

                    data_adhkar.add(new Dekr(14,3,
                            "قُلْ هُوَ اللَّهُ أَحَدٌ، اللَّهُ الصَّمَدُ، لَمْ يَلِدْ وَلَمْ يُولَدْ، وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ",
                            "من قالها حين يصبح وحين يمسى كفته من كل شىء (الإخلاص والمعوذتين). "));
                    data_adhkar.add(new Dekr(15,3,
                            "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ، مِن شَرِّ مَا خَلَقَ، وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ، وَمِن شَرِّالنَّفَّاثَاتِ فِي الْعُقَدِ، وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ",
                            "من قالها حين يصبح وحين يمسى كفته من كل شىء (الإخلاص والمعوذتين). "));
                    data_adhkar.add(new Dekr(16,3,
                            "قُلْ أَعُوذُ بِرَبِّ النَّاسِ، مَلِكِ النَّاسِ، إِلَهِ النَّاسِ، مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ، الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ، مِنَ الْجِنَّةِ وَ النَّاسِ",
                            "من قالها حين يصبح وحين يمسى كفته من كل شىء (الإخلاص والمعوذتين). "));
                    break;
                case SectionsActivity.NUM_btn_no_god_except_Allah:
                    data_adhkar.add(new Dekr(17,3,
                            "اللّهُـمَّ عافِـني في بَدَنـي ، اللّهُـمَّ عافِـني في سَمْـعي ، اللّهُـمَّ عافِـني في بَصَـري ، لا إلهَ إلاّ أَنْـتَ.",
                            "قال أبي بكرة رضي الله عنه إني سمعت رسول الله صلى الله عليه وسلم يدعو بهن"));
                    data_adhkar.add(new Dekr(18,3,
                            "اللّهُـمَّ إِنّـي أَعـوذُ بِكَ مِنَ الْكُـفر ، وَالفَـقْر ، وَأَعـوذُ بِكَ مِنْ عَذابِ القَـبْر ، لا إلهَ إلاّ أَنْـتَ.",
                            "إِنَّ رَسُولَ اللَّهِ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ كَانَ يَقُولُهُنَّ فِي دُبُرِ الصَّلَاةِ" ));
                    break;
                case SectionsActivity.NUM_btn_threes:
                    data_adhkar.add(new Dekr(19,3,
                            "سُبْحـانَ اللهِ وَبِحَمْـدِهِ عَدَدَ خَلْـقِه ، وَرِضـا نَفْسِـه ، وَزِنَـةَ عَـرْشِـه ، وَمِـدادَ كَلِمـاتِـه.",
                            "له فضل كبير لما جاء في حديث جويرية بنت الحارث رضي الله عنها" ));
                    data_adhkar.add(new Dekr(20,3,
                            "يا حَـيُّ يا قَيّـومُ بِـرَحْمَـتِكَ أَسْتَـغـيث ، أَصْلِـحْ لي شَـأْنـي كُلَّـه ، وَلا تَكِلـني إِلى نَفْـسي طَـرْفَةَ عَـين.",
                            "هذا الدعاء من أعظم الأدعية التي تتضمن تحقيق العبودية لله رب العالمين \n قال النبي ﷺ لفاطمة رضي الله عنها :\n" +
                                    "ما يمنعك أن تسمعي ما أوصيك به ، أن تقولي إذا أصبحت وإذا أمسيت : يا حي ... "));
                    data_adhkar.add(new Dekr(21,3,
                            "أسْتَغْفِرُ اللهَ العَظِيمَ الَّذِي لاَ إلَهَ إلاَّ هُوَ، الحَيُّ القَيُّومُ، وَأتُوبُ إلَيهِ.",
                            "قال رسول الله ﷺ ( من قال أستغفر الله العظيم الذي لا إله إلا هو الحي القيوم وأتوب إليه، غفر له وإن كان فر من الزحف )"));
                    data_adhkar.add(new Dekr(22,3,
                            "يَا رَبِّ , لَكَ الْحَمْدُ كَمَا يَنْبَغِي لِجَلَالِ وَجْهِكَ , وَلِعَظِيمِ سُلْطَانِكَ.",
                            "وردت في حديث ضعيف ولكنها صيغة من صيغ الحمد والثناء على الله عز وجل الجائزة،\n وقد ورد عن السلف أنهم حمدوا الله وأثنوا عليه عز وجل بألفاظ لم ترد في الكتاب والسنة إلا أن معانيها صحيحة" ));
                    data_adhkar.add(new Dekr(23,3,
                            "رَضيـتُ بِاللهِ رَبَّـاً وَبِالإسْلامِ ديـناً وَبِمُحَـمَّدٍ صلى الله عليه وسلم نَبِيّـاً.",
                            "((مَا مِنْ عَبْدٍ مُسْلِمٍ يَقُولُ حِينَ يُصْبِحُ ثلاثًا وَحِينَ يُمْسِي: رَضِيتُ بِاللَّهِ رَبًّا، وَبِالْإِسْلَامِ دِينًا، وَبِمُحَمَّدٍ صلى الله عليه وسلم نَبِيًّا إِلَّا كَانَ حَقًّا عَلَى اللَّهِ أَنْ يُرْضِيَهُ يَوْمَ الْقِيَامَةِ) ." ));
                    break;
                case SectionsActivity.NUM_btn_god_you_are_my_Lord:
                    data_adhkar.add(new Dekr(24,1,
                            "اللّهـمَّ أَنْتَ رَبِّـي لا إلهَ إلاّ أَنْتَ ، خَلَقْتَنـي وَأَنا عَبْـدُك ، وَأَنا عَلـى عَهْـدِكَ وَوَعْـدِكَ ما اسْتَـطَعْـت ، أَعـوذُ بِكَ مِنْ شَـرِّ ما صَنَـعْت ، أَبـوءُ لَـكَ بِنِعْـمَتِـكَ عَلَـيَّ وَأَبـوءُ بِذَنْـبي فَاغْفـِرْ لي فَإِنَّـهُ لا يَغْـفِرُ الذُّنـوبَ إِلاّ أَنْتَ .",
                            "من قالها موقنا بها حين يمسى ومات من ليلته دخل الجنة وكذلك حين يصبح."));
                    data_adhkar.add(new Dekr(25,1,
                            "اللَّهُمَّ أَنْتَ رَبِّي لا إِلَهَ إِلا أَنْتَ ، عَلَيْكَ تَوَكَّلْتُ ، وَأَنْتَ رَبُّ الْعَرْشِ الْكَرِيمِ , مَا شَاءَ اللَّهُ كَانَ ، وَمَا لَمْ يَشَأْ لَمْ يَكُنْ ، وَلا حَوْلَ وَلا قُوَّةَ إِلا بِاللَّهِ الْعَلِيِّ الْعَظِيمِ , أَعْلَمُ أَنَّ اللَّهَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ ، وَأَنَّ اللَّهَ قَدْ أَحَاطَ بِكُلِّ شَيْءٍ عِلْمًا , اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ نَفْسِي ، وَمِنْ شَرِّ كُلِّ دَابَّةٍ أَنْتَ آخِذٌ بِنَاصِيَتِهَا ، إِنَّ رَبِّي عَلَى صِرَاطٍ مُسْتَقِيمٍ.",
                            "ورد فيه حديث اسناده ضعيف ولكنه ذكر طيب، و ذكر عظيم، ذكر طيب لا بأس به،"));
                    break;
                case SectionsActivity.NUM_btn_mohammed_is_messenger_of_allah:
                    data_adhkar.add(new Dekr(26,10,
                            "اللَّهُمَّ صَلِّ وَسَلِّمْ وَبَارِكْ على نَبِيِّنَا مُحمَّد.",
                            "قال رسول الله ﷺ (من صلى علي حين يصبح وحين يمسي أدركته شفاعتي يوم القيامة ) ." ));
                    break;
                case SectionsActivity.NUM_btn_generic:
                    data_adhkar.add(new Dekr(27,7,
                            "حَسْبِـيَ اللّهُ لا إلهَ إلاّ هُوَ عَلَـيهِ تَوَكَّـلتُ وَهُوَ رَبُّ العَرْشِ العَظـيم.",
                            "من قالها حين يصبح وحين يمسي سبع مرات كفاه الله ماأهمه من أمر الدنيا والآخرة." ));
                    data_adhkar.add(new Dekr(28,1,
                            "اللّهُـمَّ إِنِّـي أسْـأَلُـكَ العَـفْوَ وَالعـافِـيةَ في الدُّنْـيا وَالآخِـرَة ، اللّهُـمَّ إِنِّـي أسْـأَلُـكَ العَـفْوَ وَالعـافِـيةَ في ديني وَدُنْـيايَ وَأهْـلي وَمالـي ، اللّهُـمَّ اسْتُـرْ عـوْراتي وَآمِـنْ رَوْعاتـي ، اللّهُـمَّ احْفَظْـني مِن بَـينِ يَدَيَّ وَمِن خَلْفـي وَعَن يَمـيني وَعَن شِمـالي ، وَمِن فَوْقـي ، وَأَعـوذُ بِعَظَمَـتِكَ أَن أُغْـتالَ مِن تَحْتـي.",
                            "عن ابْن عُمَرَ ، قال : لَمْ يَكُنْ رَسُولُ اللَّهِ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ يَدَعُ هَؤُلَاءِ الدَّعَوَاتِ ، حِينَ يُمْسِي ، وَحِينَ يُصْبِحُ"));
                    data_adhkar.add(new Dekr(29,10,
                            "لا الهَ إلاّ اللهُ وَحْدَهُ لا شَريْكَ لهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءِ قَدِيرِ.",
                            "من قالها عشر مرات كان كمن أعتق أربعة أنفس من ولد إسماعيل وفي رواية لمسلم من قال ذلك مائة مرة كانت له عدل عشر رقاب وكتبت له مائة حسنة وحطت عنه مائة سيئة وكانت له حرزا من الشيطان"));
                    data_adhkar.add(new Dekr(30,100,
                            "سُبْحَانَ اللَّهِ وَبِحَمْدِهِ",
                            "حُطَّتْ خَطَايَاهُ وَإِنْ كَانَتْ مِثْلَ زَبَدِ الْبَحْرِ.\n لَمْ يَأْتِ أَحَدٌ يَوْمَ الْقِيَامَةِ بِأَفْضَلَ مِمَّا جَاءَ بِهِ إِلَّا أَحَدٌ قَالَ مِثْلَ مَا قَالَ أَوْ زَادَ عَلَيْهِ." ));
                    break;
            }

        }
    }


    // نسوي نفالت لـ ال layout الذي نريده يكون الفراقمنت ونرجعه عشان بعدين يرسله الى onViewCreated
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_adhkar, container, false);

        // من stackOverflow عشان يخلي الخلفية كامل هي الخلفية الضي حددتها
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.bg_dhikr);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // نسوي انفلات لل recycler وننشى اوبجيكت من الادابتر ونرسل له البيانات و هذا الفراقمنت
        // نرسل له الفراقمنت عشان يغلقه من عنده لما ينتهي المستخدم من قراءة الاذكار اللي في الفراقمنت
        rv_adkar = view.findViewById(R.id.recyclerV_fragment_adhkar);

        MyRecyclerAdapter recyclerAdapter = new MyRecyclerAdapter(data_adhkar,list_adhkar_fragment.this);

        // المدير هو الذي يدير عملية ال recycle يعني هو الذي يشل تصميم العنصر اللي خرج ويسويه في العنصر اللي دخل
        // وهو الذي يدير عمليات ال recycler
        // نحدده من نوع Linear يعني يخلي العناصر تجي تحت بعض
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());

        // هذا كلاس عشان ننشى الخط الذي يجي فاصل بين العناصر
        DividerItemDecoration itemDecorator = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        // ارسلنا له التصميم اللي معانا بس خليت فالتصميم اللون شفاف لان انا ماشتي خط اشتي يكون فاصل مسافه بين العناصر
        itemDecorator.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(requireContext(), R.drawable.divider)));
        // اضيف الفاصل الى الـ recycler
        rv_adkar.addItemDecoration(itemDecorator);
        // العناصر اللي داخل ال recycler ثابتة الحجم يعني مابش واحد اكبر من الثاني او متغيرات الحجم
        // ليش لازم نقول له، مع انه قد خليناهن ثابتات وحددنا حجمهن في التصميم؟
        // ج/ عشان هذا الداله تتأكد انه ثابت وتزيد من الاداء
        rv_adkar.setHasFixedSize(true);
        // نضيف له المدير والادابتر
        rv_adkar.setLayoutManager(manager);
        rv_adkar.setAdapter(recyclerAdapter);

    }

    // في هذه الداله بالذات ، نحدد طول وعرض الفراقمنت
    @Override
    public void onResume() {
        super.onResume();
        int width = getResources().getDimensionPixelSize(R.dimen.dialog_width);
        int height = getResources().getDimensionPixelSize(R.dimen.dialog_height);
        getDialog().getWindow().setLayout(width, height);
    }




    // ال listener هذا انا عرفته فوق وخليته يساوي الاكتفتي اللي نفذته
    // اول ما تنتهي الفراقمنت استدعي الداله اللي منفذه هناك
    @Override
    public void onDetach() {
        super.onDetach();
        listener.onDhekrClick();
    }

    // الليسنر هذا عادي اذا عرفته في مكان ثاني مش مهم وين هو
    interface onDhekrClicked {
        void onDhekrClick();
    }




}