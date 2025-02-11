package ru.smak.ui

import ru.smak.math.fractals.Mandelbrot
import ru.smak.ui.painting.CartesianPlane
import ru.smak.ui.painting.SelectablePanel
import ru.smak.ui.painting.fractals.FractalPainter
import ru.smak.ui.painting.fractals.colorizers
import java.awt.Color
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import java.awt.event.*
import javax.swing.*
import javax.swing.*
import kotlin.random.Random


class MainFrame : JFrame() {

    val fractalPanel: SelectablePanel
    var frame: JFrame //= null
    val menu: JMenu
    val menuBar: JMenuBar

    val stat = mutableListOf(Pair(Pair(-2.0,1.0),Pair(-1.0,1.0)) )

    init{
        defaultCloseOperation = EXIT_ON_CLOSE
        minimumSize = Dimension(600, 400)
        val painter = FractalPainter(
            Mandelbrot(),
            CartesianPlane(-2.0, 1.0, -1.0, 1.0),
            colorizers[Random.nextInt(colorizers.size)])

        frame = JFrame()
        menu = JMenu()
        menuBar = JMenuBar()
        menuBar.setBounds(0, 0, 350, 30)
        val fileMenu = JMenu("Файл")
        menuBar.add(fileMenu)
        val loadMenu = JMenuItem("Загрузить")
        fileMenu.add(loadMenu)
        val SourceAreaMenu = JMenuItem("Исходная область")
        fileMenu.add(SourceAreaMenu)
        val OpenMenu = JMenuItem("Открыть...")
        fileMenu.add(OpenMenu)
        val SaveMenu = JMenu("Сохранить как")
        val fracMenu = JMenuItem("Фрактал")
        val imageMenu = JMenuItem("Изображение")
        SaveMenu.add(fracMenu)
        SaveMenu.add(imageMenu)
        fileMenu.add(SaveMenu)

        val FractalMenu = JMenu("Фрактал")
        menuBar.add(FractalMenu)
        val ColorSitemMenu = JMenu("Цветовая схема")
        //val ColorSitem1Menu = JRadioButtonMenuItem("Чёрно-белый") // вариант с кнопкой
        val ColorSitem1Menu = JMenuItem("Чёрно-белый")
        val ColorSitem2Menu = JMenuItem("Сине-зеленый")
        val ColorSitem3Menu = JMenuItem("Красно-зелёный")
        val ColorSitem4Menu = JMenuItem("Красно-синий")
        val TypeFracMenu = JMenu("Тип фрактала")
        val Type2 = JMenuItem("Множество Мандельброта 2 степени")
        val Type3 = JMenuItem("Множество Мандельброта 3 степени")
        val Type4 = JMenuItem("Множество Мандельброта 4 степени")
        val Type5 = JMenuItem("Множество Мандельброта 5 степени")
        val DynamicMenu = JCheckBoxMenuItem("Динамические итерации")
        val SaveRationMenu = JCheckBoxMenuItem("Сохранение отношения")
        val ExcursionMenu = JMenuItem("Создание экскурсии")
        ColorSitemMenu.add(ColorSitem1Menu)
        ColorSitemMenu.add(ColorSitem2Menu)
        ColorSitemMenu.add(ColorSitem3Menu)
        ColorSitemMenu.add(ColorSitem4Menu)
        TypeFracMenu.add(Type2)
        TypeFracMenu.add(Type3)
        TypeFracMenu.add(Type4)
        TypeFracMenu.add(Type5)
        FractalMenu.add(ColorSitemMenu)
        FractalMenu.add(TypeFracMenu)
        FractalMenu.add(DynamicMenu)
        FractalMenu.add(SaveRationMenu)
        FractalMenu.add(ExcursionMenu)

        loadMenu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })

        SourceAreaMenu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })

        OpenMenu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })

        fracMenu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })

        imageMenu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })

        ColorSitem1Menu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        ColorSitem2Menu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        ColorSitem3Menu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        ColorSitem4Menu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })

        Type2.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        Type3.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        Type4.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        Type5.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        DynamicMenu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })

        ExcursionMenu.addMouseListener(object: MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)

            }
        })
        fractalPanel = SelectablePanel(painter).apply {
            background = Color.WHITE
            addSelectListener{
                with (painter.plane){
                    val xMin = xScr2Crt(it.x)
                    val yMin = yScr2Crt(it.y)
                    val xMax = xScr2Crt(it.x + it.width)
                    val yMax = yScr2Crt(it.y + it.height)
                    xSegment = Pair(xMin, xMax)
                    ySegment = Pair(yMin, yMax)

                    stat.add(Pair(Pair(xMin,xMax),Pair(yMin,yMax)))
                }
                repaint()
            }
        }

        fractalPanel.getInputMap().put(KeyStroke.getKeyStroke("control A"),"foo")

        fractalPanel.addKeyListener(object : KeyListener{
            override fun keyTyped(e: KeyEvent?) {

            }

            override fun keyPressed(e: KeyEvent?) {
            }

            override fun keyReleased(e: KeyEvent?) {
                e?.let{
                    if(e.keyChar=='\u001A'){
                        if(stat.size!=1)
                            stat.removeAt(stat.size-1)
                        with (painter.plane){
                            xSegment = stat[stat.size-1].first
                            ySegment = stat[stat.size-1].second
                        }
                    }
                    repaint()
                }
            }
        })

        layout = GroupLayout(contentPane).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                            .addComponent(fractalPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                    )
                    .addGap(4)

            )

            setVerticalGroup(
                createSequentialGroup()
                    .addGap(4)
                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(4)
                    .addComponent(fractalPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                    .addGap(4)
            )
        }
    }

    //fun onSelectArea(r: Rectangle)
}